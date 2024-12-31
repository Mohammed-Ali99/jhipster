package com.spring.websocketapp.service.impl;

import com.spring.websocketapp.domain.ChatRoom;
import com.spring.websocketapp.repository.ChatRoomRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
        return chatRoomRepository
            .findBySenderIdAndRecipientId(senderId, recipientId)
            .map(ChatRoom::getChatId)
            .or(() -> {
                if (createNewRoomIfNotExists) {
                    String chatId = createChatId(senderId, recipientId);
                    return Optional.of(chatId);
                }

                return Optional.empty();
            });
    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = new ChatRoom();
        senderRecipient.setChatId(chatId);
        senderRecipient.setSenderId(senderId);
        senderRecipient.setRecipientId(recipientId);

        ChatRoom recipientSender = new ChatRoom();
        recipientSender.setChatId(chatId);
        recipientSender.setSenderId(recipientId);
        recipientSender.setRecipientId(senderId);

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
