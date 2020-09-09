package com.learnappium.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnappium.provider.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Component
public class UserProvider {

    @Autowired
    private ObjectMapper mapper;

    public User getUser(String scenario) {
        InputStream dataFile = getClass().getResourceAsStream("/data/users.json");

        if (dataFile == null) {
            throw new RuntimeException("Failed to load users.json");
        }

        try {
            HashMap<String, User> data = mapper.readValue(dataFile, new TypeReference<HashMap<String, User>>() {
            });

            return data.get(scenario);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
