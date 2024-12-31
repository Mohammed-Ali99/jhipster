package com.spring.websocketapp.repository;

import com.spring.websocketapp.domain.NewUser;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewUserRepository extends JpaRepository<NewUser, Long> {
    List<NewUser> findAllByStatus(String status);

    Optional<NewUser> findByNickName(String nickName);
}
