package common.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class JsonNodeConverter implements AttributeConverter<JsonNode, String> {
    private Logger logger = LoggerFactory.getLogger(JsonNodeConverter.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(JsonNode jsonNode) {
        return jsonNode == null || jsonNode.isNull() ? null : jsonNode.toString();
    }

    @Override
    public JsonNode convertToEntityAttribute(String s) {
        try {
            return s == null ? null : objectMapper.readTree(s);
        } catch (IOException e) {
            logger.error("Can not convert to JsonNode");
        }
        return null;
    }
}
