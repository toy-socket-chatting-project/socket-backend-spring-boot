package com.lk.chat.chatting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    ERROR,
    WARNING,
    INFO,
    NONE,
}
