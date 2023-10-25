package com.cotiviti.ecommerce.service;


import com.cotiviti.ecommerce.dto.KhaltiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class KhaltiService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> initiateKhaltiPay(KhaltiRequest khaltiRequest) {
        String url = "https://a.khalti.com/api/v2/epayment/initiate/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Key a3b7295c35034374a805eac82b55c5af");
        HttpEntity<KhaltiRequest> requestEntity = new HttpEntity<>(khaltiRequest, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return responseEntity;
    }
}
