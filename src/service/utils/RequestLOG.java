package service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.util.ContentCachingRequestWrapper;
import vn.com.vndirect.brokerinsight.model.response.ErrorResponse;
import vn.com.vndirect.vndid.auth.UserAuthentication;
import vn.com.vndirect.vndid.session.model.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RequestLOG {
    private static final String HTTP_STATUS = "httpStatus";
    private static final String URL = "url";
    private static final String METHOD = "method";
    private static final String BODY = "body";
    private static final String RESPONSE = "response";
    private static final String USER = "user";

    private static final Logger logger = LoggerFactory.getLogger(RequestLOG.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void error(HttpServletRequest request, HttpStatus httpStatus, ErrorResponse errResp, Throwable ex) {
        int status = httpStatus.value();
        JsonNode msg = createLogMsg(request, status, errResp);
        if (status < 400) {
            logger.info("Checkout request: {}", msg.toString(), ex);
        } else if (status < 500) {
            logger.warn("Checkout request: {}", msg.toString(), ex);
        } else {
            logger.error("Checkout request: {}", msg.toString(), ex);
        }
    }

    public static void info(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        if (status < 300) {
            JsonNode msg = createLogMsg(request, status);
            logger.info("Checkout request: {}", msg.toString());
        }
    }

    public static void info(HttpServletRequest request) {
        JsonNode msg = createLogMsg(request, HttpStatus.PROCESSING.value());
        logger.info("Entrance request: {}", msg.toString());
    }

    private static ObjectNode createLogMsg(HttpServletRequest request, int httpStatus) {
        ObjectNode objectMsg = objectMapper.createObjectNode()
                .put(HTTP_STATUS, httpStatus);
        String url = request.getRequestURL().toString();
        if (request.getQueryString() != null) {
            url = url + "?" + request.getQueryString();
        }
        objectMsg.put(URL, url)
                .put(METHOD, request.getMethod());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof UserAuthentication) {
            UserSession user = (UserSession) auth.getDetails();
            objectMsg.put(USER, user.getUser().getUserName());
        }
        try {
            String body = getRequestBody(request);
            if (body != null && request.getContentType() != null && request.getContentType().toLowerCase().startsWith("application/json")) {
                objectMsg.set(BODY, objectMapper.readValue(body, JsonNode.class));
            } else {
                objectMsg.put(BODY, body);
            }
        } catch (IOException e1) { //never happen
            LoggerFactory.getLogger("RequestBody").error("can't get request body", e1);
        }
        return objectMsg;
    }

    private static JsonNode createLogMsg(HttpServletRequest request, int httpStatus, ErrorResponse errResp) {
        return createLogMsg(request, httpStatus)
                .set(RESPONSE, objectMapper.convertValue(errResp, JsonNode.class));
    }

    private static String getRequestBody(HttpServletRequest request) throws UnsupportedEncodingException {
        if (!(request instanceof ContentCachingRequestWrapper)) {
            return null;
        }
        byte[] bodyContent = ((ContentCachingRequestWrapper) request).getContentAsByteArray();
        if (bodyContent.length == 0) {
            return null;
        }
        return new String(bodyContent, request.getCharacterEncoding());
    }
}
