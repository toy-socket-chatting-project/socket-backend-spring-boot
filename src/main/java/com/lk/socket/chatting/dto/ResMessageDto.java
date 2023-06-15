package com.lk.socket.chatting.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(name = "ResReceiveDto", description = "메시지 응답 Dto")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ResMessageDto {

    @Schema(description = "메시지 전송시간")
    private String responseTime;

    @Schema(description = "전송자 구분용 세션 Id")
    private String simpSessionId;

    @Schema(description = "전송자 닉네임")
    private String nickname;

    @Schema(description = "전송자 닉네임 컬러")
    private String nicknameColor;

    @Schema(description = "전송자 메시지 내용")
    private String contents;

    @Schema(description = "전송자 Base64 이미지 목록")
    private List<String> recvImgSrcList;

}
