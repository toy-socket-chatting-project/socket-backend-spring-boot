package com.lk.chat.chatroom.service;

import com.lk.chat.chatroom.dto.ChatRoomDto;
import com.lk.chat.chatroom.repository.ChatRoom;
import com.lk.chat.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;


//    public ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }

    public List<ChatRoomDto> findAll() {
        return chatRoomRepository.findAll().stream()
                .map(ChatRoomDto::new)
                .collect(Collectors.toList());
    }

    public List<ChatRoomDto> findAllByRoomName(String roomName) {
        return chatRoomRepository.findAllByRoomName(roomName).stream()
                .map(ChatRoomDto::new)
                .collect(Collectors.toList());
    }

    public ChatRoom saveChatRoom(ChatRoomDto chatRoomDto){
        return chatRoomRepository.save(chatRoomDto.toEntity());
    }

    public ChatRoom deleteChatRoom(ChatRoomDto chatRoomDto) {
        return chatRoomRepository.save(chatRoomDto.toEntity().delete());
    }
}
