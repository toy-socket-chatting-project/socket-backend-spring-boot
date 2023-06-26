package com.lk.chat.chatroom.controller;

import com.lk.chat.chatroom.dto.ChatRoomDto;
import com.lk.chat.chatroom.service.ChatRoomService;
import com.lk.chat.dto.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.lk.chat.dto.ApiResult.ok;


@Tag(name = "ChatRoomController", description = "채팅방 컨트롤러")
@Log4j2
@RestController
@RequestMapping("/socket/messenger")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    //채팅방 목록 조회
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success",
                    content = @Content(schema = @Schema(implementation = ChatRoomDto.class))),
    })
    @Operation(summary = "findAll rooms", description = "채팅방 전체조회")
    @GetMapping(value = "/rooms")
    public ApiResult<List<ChatRoomDto>> rooms() {
        return ok(chatRoomService.findAll());
    }

    //채팅방 개설
    @GetMapping(value = "/room")
    public void create(@RequestParam String name) {
        log.info("# Create Chat Room , name: " + name);
//        chatRoomService.createChatRoomDTO(name);
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
