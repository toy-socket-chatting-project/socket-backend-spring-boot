package com.lk.socket.chatroom.service;

import com.lk.socket.chatroom.dto.ChatRoomDto;
import com.lk.socket.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoomDto> findAllRooms() {
        //채팅방 생성 순서 최근 순으로 반환
        List<ChatRoomDto> result = chatRoomRepository.findAllRooms();
        Collections.reverse(result);

        return result;
    }

//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }

    public void createChatRoomDTO(String name) {
        chatRoomRepository.createChatRoomDTO(name);
    }
}
