package com.spring.websocketapp.web.rest;

import com.spring.websocketapp.domain.NewUser;
import com.spring.websocketapp.service.UserService;
import com.spring.websocketapp.service.impl.NewUSerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class NewUserController {

    @Autowired
    private NewUSerService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public NewUser addUser(@Payload NewUser user) {
        userService.save(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public NewUser disconnectUser(@Payload NewUser user) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<NewUser>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findAllConnectedUsers());
    }
}
