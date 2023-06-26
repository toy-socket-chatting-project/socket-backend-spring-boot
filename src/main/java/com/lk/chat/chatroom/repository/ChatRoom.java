package com.lk.chat.chatroom.repository;

import com.lk.chat.repository.ChatBaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@Entity
@Table(indexes = {
        @Index(name = "idx_room_id", columnList = "roomId", unique = true),
        @Index(name = "idx_room_name", columnList = "roomName")
})
public class ChatRoom extends ChatBaseEntity {

    @Comment("순번")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("방ID")
    @NotBlank
    @Length(max = 10)
    @Column(nullable = false, length = 10)
    private String roomId;

    @Comment("방이름")
    @NotBlank
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String roomName;

}
