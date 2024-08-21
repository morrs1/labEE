package com.example.labee.model.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class JSONParser {
    public static Map<String, String> parse(BufferedReader readerOfJson) throws IOException {
        StringBuilder stringBuilderForParameters = new StringBuilder();
        String lineOfFileParameters;

        while ((lineOfFileParameters = readerOfJson.readLine()) != null) {
            stringBuilderForParameters.append(lineOfFileParameters);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(stringBuilderForParameters.toString(), new TypeReference<>() {});
    }
}
