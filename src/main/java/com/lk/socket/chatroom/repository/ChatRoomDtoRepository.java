package com.lk.socket.chatroom.repository;

import com.lk.socket.chatroom.dto.ChatRoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ChatRoomDtoRepository {

    private final Map<String, ChatRoomDto> chatRoomDtoMap;

    public ChatRoomDtoRepository() {
        this.chatRoomDtoMap = new LinkedHashMap<>();
    }
    public List<ChatRoomDto> findAll(){
        //채팅방 생성 순서 최근 순으로 반환
        return new ArrayList<>(chatRoomDtoMap.values());
    }

//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDtoMap.get(id);
//    }

    public void save(String name){
        ChatRoomDto room = ChatRoomDto.create(name);
        chatRoomDtoMap.put(room.getRoomId(), room);
    }

}
