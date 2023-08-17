package com.example.observationservice.tool;

import com.example.observationservice.dto.CelestialObjectDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class RestClient<T,V> {
    private String urlApiUtilisateur = "http://localhost:8080/api/";

    private String urlApiCelstialObject = "http://localhost:8081/api/";

    private String urlApiToken = "http://localhost:8083/api/test";
    private RestTemplate template;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T getUtilisateur(String uri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiUtilisateur+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }

    public CelestialObjectDTO getCelestialObject(String uri, Class<CelestialObjectDTO> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<CelestialObjectDTO> response = template.exchange(urlApiCelstialObject+uri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }


    public boolean testToken(String token, Class<T> type) {
        httpHeaders.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiToken, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getStatusCode().is2xxSuccessful();
        }
        return false;
    }
}
