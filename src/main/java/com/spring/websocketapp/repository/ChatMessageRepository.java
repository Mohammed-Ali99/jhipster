package com.spring.websocketapp.repository;

import com.spring.websocketapp.domain.ChatMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatId(String chatId);
}
