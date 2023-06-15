package com.lk.socket.chatting.controller;

import com.lk.socket.chatting.dto.ReqMessageDto;
import com.lk.socket.chatting.dto.ResMessageDto;
import com.lk.socket.chatting.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.joda.time.LocalDateTime;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChattingController {


    private final ChattingService chattingService;

    /**
     * <h3>메시지 전송</h3>
     *
     * @param reqMessageDto  {@link ReqMessageDto 메시지 요청 Dto}
     * @param headerAccessor {@link SimpMessageHeaderAccessor Stomp 메시지 헤더}
     * @return {@link ResMessageDto 메시지 응답 Dto}
     */
    @MessageMapping("/socket/messenger/receive")
    @SendTo("/socket/messenger/send")
    public ResMessageDto messageReceiveSend(@Payload ReqMessageDto reqMessageDto, SimpMessageHeaderAccessor headerAccessor) {
        var simpSessionId = String.valueOf(headerAccessor.getHeader("simpSessionId"));
        return ResMessageDto.builder()
                .responseTime(LocalDateTime.now().toString("yy.MM.dd HH:mm:ss.SSS"))
                .simpSessionId(simpSessionId)
                .nickname(reqMessageDto.getNickname())
                .nicknameColor(chattingService.getColorById(simpSessionId))
                .contents(reqMessageDto.getContents())
                .recvImgSrcList(chattingService.getResizeImgSrcList(reqMessageDto.getSendImgSrcList()))
                .build();
    }

}
