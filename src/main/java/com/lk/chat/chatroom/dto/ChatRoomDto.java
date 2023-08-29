package com.lk.chat.chatroom.dto;

import com.lk.chat.chatroom.repository.ChatRoom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Schema(name = "chatRoomDto", description = "채팅방 Dto")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomDto {
    private String name;

    public ChatRoomDto(ChatRoom chatRoom) {
        this.name = chatRoom.getRoomName();
    }

    public ChatRoom toEntity(){
        return ChatRoom.builder().roomName(name).build();
    }
}
