package com.lk.socket.chatroom.controller;

import com.lk.socket.chatroom.dto.ChatRoomDto;
import com.lk.socket.chatroom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/socket/messenger")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public List<ChatRoomDto> rooms() {
        return chatRoomService.findAllRooms();
    }

    //채팅방 개설
    @GetMapping(value = "/room")
    public void create(@RequestParam String name) {
        log.info("# Create Chat Room , name: " + name);
        chatRoomService.createChatRoomDTO(name);
    }

//    //채팅방 조회
//    @GetMapping("/room")
//    public void getRoom(String roomId, Model model){
//
//        log.info("# get Chat Room, roomID : " + roomId);
//
//        model.addAttribute("room", chatRoomService.findRoomById(roomId));
//    }
}
