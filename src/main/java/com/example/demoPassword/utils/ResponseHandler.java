package com.example.demoPassword.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, Object responseObject) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("status", httpStatus.value());
            map.put("data", responseObject);
            return new ResponseEntity<>(map, httpStatus);
        } catch (Exception e) {
            map.clear();
            map.put("status", httpStatus.value());
            map.put("data", null);
            return new ResponseEntity<>(map, httpStatus);
        }
    }
}
