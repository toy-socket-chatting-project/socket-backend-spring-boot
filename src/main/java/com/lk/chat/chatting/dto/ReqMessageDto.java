package com.lk.chat.chatting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.*;

@Schema(name = "ReqReceiveDto", description = "메시지 요청 Dto")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReqMessageDto {

    @Schema(description = "닉네임")
    private String nickname;

    @Schema(description = "전달할 내용")
    private String contents;

    @Schema(description = "Base64 이미지 목록")
    private List<String> sendImgSrcList;
}
