package controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vndirect.brokerinsight.model.request.BrokerFilterRequest;
import vn.com.vndirect.brokerinsight.model.request.BrokerRequest;
import vn.com.vndirect.brokerinsight.model.response.BrokerResponse;
import vn.com.vndirect.brokerinsight.model.response.DataResponse;
import vn.com.vndirect.brokerinsight.service.BrokerService;
import vn.com.vndirect.brokerinsight.service.utils.Models;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brains")
public class BrokerController {
    private final BrokerService brokerService;

    @Autowired
    public BrokerController(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @GetMapping("/crit")
    public ResponseEntity<Page<BrokerResponse>> getBrokers(@ModelAttribute BrokerFilterRequest request) {
        Models.refine(request, Models::trimString);

        if (StringUtils.isEmpty(request.getSortBy())) request.setSortBy("createdDate:DESC");


        return ResponseEntity.ok(brokerService.getBrokers(request));

    }

    @GetMapping(value = "/uid/{userId}")
    public BrokerResponse getBroker(@PathVariable Long userId) {
        return brokerService.getBrokerResponse(userId);
    }

    @GetMapping
    public ResponseEntity<BrokerResponse> getBrokerByType(@RequestParam(name = "userName") String username,
                                                          @RequestParam(name = "brokerType") String brokerType) {
        BrokerResponse brokerResponse = brokerService.getBrokerResponseByUserNameAndBrokerType(username, brokerType);

        return ResponseEntity.ok(brokerResponse);
    }

    @GetMapping(value = "/usn/{username}")
    public ResponseEntity<BrokerResponse> getBroker(@PathVariable String username) {
        BrokerResponse brokerResponse = brokerService.getBrokerByUserName(username);

        return ResponseEntity.ok(brokerResponse);
    }

    @GetMapping(value = "/usn/internal/{username}")
    public ResponseEntity<BrokerResponse> getBrokerInternal(@PathVariable String username) {
        BrokerResponse brokerResponse = brokerService.getBrokerByUserName(username);

        return ResponseEntity.ok(brokerResponse);
    }


    @GetMapping("/usn/internal/broker")
    public ResponseEntity<List<BrokerResponse>> getBrokerLike(@ModelAttribute BrokerFilterRequest filterRequest) {
        Models.refine(filterRequest, Models::trimString);

        if (StringUtils.isEmpty(filterRequest.getSortBy())) filterRequest.setSortBy("createdDate:DESC");
        List<BrokerResponse> brokerResponse = brokerService.getByUserNameLike(filterRequest);

        return ResponseEntity.ok(brokerResponse);
    }


    @GetMapping("/internal/broker")
    public ResponseEntity<BrokerResponse> getBrokerForUserNameAndBrokerType(@ModelAttribute BrokerFilterRequest filterRequest) {

        return ResponseEntity.ok(brokerService.getBroker(filterRequest));
    }

    @GetMapping(value = "/internal/customerId/{customerId}")
    public ResponseEntity<?> getBrokerInternalByCustomerId(@PathVariable String customerId) {
        BrokerResponse brokerResponse = brokerService.getBrokerByCustomerId(customerId);

        if (brokerResponse == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(brokerResponse);
    }

    @PostMapping("/external")
    public BrokerResponse createBrokerExternal(@RequestBody @Valid BrokerRequest request) {
        return brokerService.createBrokerExternal(request);
    }

    @PostMapping
    public BrokerResponse createBroker(@RequestBody @Valid BrokerRequest request) {
        return brokerService.createBroker(request);
    }

    @PatchMapping(value = "/broker/{id}")
    public BrokerResponse updateBrokerExternal(@RequestParam(name = "status") boolean status,
                                       @PathVariable Long id) {
        return brokerService.updateStatus(id, status);
    }

    @PatchMapping(value = "/broker/{id}/status")
    public BrokerResponse updateStatus(@RequestBody BrokerRequest brokerRequest,
                                       @PathVariable Long id) {
        return brokerService.updateBrokerExternal(id, brokerRequest);
    }

    @PatchMapping(value = "/broker/external/{id}")
    public BrokerResponse updateBroker(@RequestBody BrokerRequest brokerRequest,
                                       @PathVariable Long id) {
        return brokerService.updateBroker(id, brokerRequest);
    }

    @GetMapping("/internal")
    public ResponseEntity<DataResponse> getBrokersInternal(@ModelAttribute BrokerFilterRequest request) {
        Models.refine(request, Models::trimString);

        if (StringUtils.isEmpty(request.getSortBy())) request.setSortBy("createdDate:DESC");
        Page<BrokerResponse> brokerResponses = brokerService.getBrokersInternal(request);
        DataResponse<BrokerResponse> dataResponse = new DataResponse<>();
        dataResponse.setPageSize(request.getPageSize());
        dataResponse.setPageIndex(request.getPageIndex());
        dataResponse.setData(brokerResponses.getContent());
        dataResponse.setTotalItem(brokerResponses.getTotalElements());

        return ResponseEntity.ok(dataResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        brokerService.delete(id);

        return ResponseEntity.ok().build();
    }

}
