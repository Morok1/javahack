package com.raif.javahack.javahack.intdadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Controller
public class DaDataController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String DA_DATA_URL  = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party/";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final static String AUTHORIZATION = "Authorization";
    private final static String TOKEN = "Token bf259c2f85c6d2f1d7ec24275930310af6e9448f";
    private final static String QUERY = "query";
    private static final String QUERY_NUMBER = "7707083893";

    @GetMapping("/data")
    public @ResponseBody String getUserData() throws JSONException, IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHORIZATION, TOKEN);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(QUERY, QUERY_NUMBER);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);

        ResponseEntity<String> result =  restTemplate.exchange(DA_DATA_URL, HttpMethod.POST, entity, String.class);

        JsonNode root = objectMapper.readTree(result.getBody());
        JsonNode jsonNode = root.get("suggestions").get(0).get("value");

        return  jsonNode.textValue();
    }

}
