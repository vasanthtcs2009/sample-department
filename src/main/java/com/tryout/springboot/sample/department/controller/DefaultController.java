package com.tryout.springboot.sample.department.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultController {

    @GetMapping(path = "*", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> applicationDefaultBootHandler() {
        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("responseCode", "0000");
        responseMap.put("responseDescription", "Success");
        responseMap.put("responseDescriptionText", "Application Boot Success");
        return responseMap;
    }

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> applicationHelloHandler() {
        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("responseCode", "0000");
        responseMap.put("responseDescription", "Success");
        responseMap.put("responseDescriptionText", "Hello from Application");
        return responseMap;
    }

}
