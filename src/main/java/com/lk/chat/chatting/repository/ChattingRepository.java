package com.lk.chat.chatting.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

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
