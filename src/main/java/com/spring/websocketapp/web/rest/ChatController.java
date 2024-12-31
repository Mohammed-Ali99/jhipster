package com.spring.websocketapp.web.rest;

import com.spring.websocketapp.domain.ChatMessage;
import com.spring.websocketapp.domain.ChatNotification;
import com.spring.websocketapp.service.impl.ChatMessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
            chatMessage.getRecipientId(),
            "/queue/messages",
            new ChatNotification(savedMsg.getId(), savedMsg.getSenderId(), savedMsg.getRecipientId(), savedMsg.getContent())
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId, @PathVariable String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }
}
