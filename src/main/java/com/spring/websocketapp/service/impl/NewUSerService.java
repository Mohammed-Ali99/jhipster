package com.spring.websocketapp.service.impl;

import com.spring.websocketapp.domain.NewUser;
import com.spring.websocketapp.repository.NewUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUSerService {

    @Autowired
    private NewUserRepository repository;

    public void save(NewUser newUser) {
        newUser.setStatus("ONLINE");
        repository.save(newUser);
    }

    public void disconnect(NewUser user) {
        NewUser storedUser = repository.findByNickName(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus("OFFLINE");
            repository.save(storedUser);
        }
    }

    public List<NewUser> findAllConnectedUsers() {
        return repository.findAllByStatus("ONLINE");
    }
}
