package com.lk.chat.chatroom.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    List<ChatRoom> findAllByRoomName(String roomName);
}
