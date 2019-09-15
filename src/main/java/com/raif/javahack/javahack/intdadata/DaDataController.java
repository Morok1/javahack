package com.raif.javahack.javahack.intdadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raif.javahack.javahack.intdadata.api.UserDataApi;
import com.raif.javahack.javahack.intdadata.model.UserDto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Controller
public class DaDataController implements UserDataApi {
    private static final String DA_DATA_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party/";
    private final static String AUTHORIZATION = "Authorization";
    private final static String TOKEN = "Token bf259c2f85c6d2f1d7ec24275930310af6e9448f";
    private final static String QUERY = "query";
    private final static String SUGGESTIONS = "suggestions";
    private final static String DATA = "data";
    private final static String OKVED = "okved";
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private RestTemplate restTemplate;
//    private static final String QUERY_NUMBER = "7707083893";


    public @ResponseBody
    UserDto getUserDataByInn(@PathVariable("inn") Long inn) throws JSONException, IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHORIZATION, TOKEN);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(QUERY, inn);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);

        ResponseEntity<String> result = restTemplate.exchange(DA_DATA_URL, HttpMethod.POST, entity, String.class);

        JsonNode root = objectMapper.readTree(result.getBody());

        UserDto userDto = getUserDto(root);
        userDto.setInn(inn);

        return userDto;
    }

    private UserDto getUserDto(JsonNode root) {
        UserDto dto = new UserDto();
        JsonNode node = root.get(SUGGESTIONS).get(0).get(DATA).get(OKVED);
        String fullOKVED = node.textValue();

        Integer shortOKVED = Integer.valueOf(fullOKVED.split("\\.")[0]);
        Integer category = Integer.valueOf(fullOKVED.split("\\.")[1]);

        dto.setOkved(shortOKVED);
        dto.setCategory(category);


        return dto;
    }

}
