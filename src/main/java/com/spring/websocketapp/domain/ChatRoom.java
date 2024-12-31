package com.spring.websocketapp.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "chat_rooms")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAT_ROOM_SEQ")
    @SequenceGenerator(name = "CHAT_ROOM_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "recipient_id")
    private String recipientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }
}
