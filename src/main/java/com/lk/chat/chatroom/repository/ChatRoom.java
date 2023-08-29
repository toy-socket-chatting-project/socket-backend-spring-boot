package com.lk.chat.chatroom.repository;

import com.lk.chat.repository.ChatBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(name = "idx_room_name", columnList = "roomName")
})
public class ChatRoom extends ChatBaseEntity {

    @Comment("순번")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("방이름")
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String roomName;

    @Builder
    public ChatRoom(String roomName){
        this.roomName = roomName;
        this.useYn = "Y";
    }
    public ChatRoom delete(){
        useYn = "N";
        return this;
    }
}
