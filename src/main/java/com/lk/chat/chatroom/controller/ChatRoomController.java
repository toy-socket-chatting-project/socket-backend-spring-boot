package com.lk.chat.chatroom.controller;

import com.lk.chat.chatroom.dto.ChatRoomDto;
import com.lk.chat.chatroom.service.ChatRoomService;
import com.lk.chat.dto.ResListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ChatRoomController", description = "채팅방 컨트롤러")
@Log4j2
@RestController
@RequestMapping("/socket/messenger")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 목록 조회
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "success",
                        content = @Content(schema = @Schema(implementation = ChatRoomDto.class))),
            })
    @Operation(summary = "findAll rooms", description = "채팅방 전체조회")
    @GetMapping(value = "/rooms")
    public ResListDto<List<ChatRoomDto>> rooms() {
        return new ResListDto(chatRoomService.findAll());
    }

    // 채팅방 개설
    @PostMapping(value = "/saveChatRoom")
    public void create(@RequestBody ChatRoomDto chatRoomDto) {
        log.info("# Create Chat Room , name: " + chatRoomDto);
        chatRoomService.saveChatRoom(chatRoomDto);
    }

    @PostMapping(value = "/deleteChatRoom")
    public void delete(@RequestBody ChatRoomDto chatRoomDto) {
        chatRoomService.deleteChatRoom(chatRoomDto);
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
