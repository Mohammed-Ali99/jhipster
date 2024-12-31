package com.spring.websocketapp.domain;

import jakarta.persistence.*;

@Table(name = "new_users")
@Entity
public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEW_USER_SEQ")
    @SequenceGenerator(name = "NEW_USER_SEQ", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
