package com.lk.socket.chatting.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ChattingRepository {

    private final Map<String, String> idColorMap = new HashMap<>();

    public boolean isContainsKey(String simpSessionId) {
        return idColorMap.containsKey(simpSessionId);
    }

    public String getColorById(String simpSessionId) {
        return idColorMap.get(simpSessionId);
    }

    public void putColor(String simpSessionId, String colorHexCode) {
        idColorMap.put(simpSessionId, colorHexCode);
    }

}
