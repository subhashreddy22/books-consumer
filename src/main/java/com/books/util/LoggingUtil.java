package com.books.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> String getString(T t) {
        String val = null;
        try {
            val = mapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return val;
    }
}
