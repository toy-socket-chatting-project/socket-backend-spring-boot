package com.lk.socket.chatroom.service;

import com.lk.socket.chatroom.dto.ChatRoomDto;
import com.lk.socket.chatroom.repository.ChatRoomDtoRepository;
import com.lk.socket.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomDtoRepository chatRoomDtoRepository;

    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoomDto> findAllRooms() {
        //채팅방 생성 순서 최근 순으로 반환
        List<ChatRoomDto> result = chatRoomDtoRepository.findAll();
        Collections.reverse(result);

        return result;
    }

//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }

    public void createChatRoomDTO(String name) {
        chatRoomDtoRepository.save(name);
    }

    public List<ChatRoomDto> findAll() {
        return chatRoomRepository.findAll().stream()
                .map(ChatRoomDto::new)
                .collect(Collectors.toList());
    }
}
