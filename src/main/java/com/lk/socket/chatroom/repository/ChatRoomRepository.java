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
public class ChatRoomRepository {

    private final Map<String, ChatRoomDto> chatRoomDTOMap;

    public ChatRoomRepository() {
        this.chatRoomDTOMap = new LinkedHashMap<>();
    }
    public List<ChatRoomDto> findAllRooms(){
        //채팅방 생성 순서 최근 순으로 반환
        return new ArrayList<>(chatRoomDTOMap.values());
    }

//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }

    public void createChatRoomDTO(String name){
        ChatRoomDto room = ChatRoomDto.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);
    }

}
