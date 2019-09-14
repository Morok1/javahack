package com.raif.javahack.javahack.intdadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Controller
public class DaDataController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/data")
    public String getUserData(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("aa52191835b0023aa9987e130101cd3ee09f7553");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final String DA_DATA_URL  = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(DA_DATA_URL, HttpMethod.GET, entity, String.class).getBody();

    }



}
