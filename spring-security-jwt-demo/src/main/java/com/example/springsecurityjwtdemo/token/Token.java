package com.example.springsecurityjwtdemo.token;

import com.example.springsecurityjwtdemo.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue
    private Long id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokeType tokeType;

    private Boolean expired;

    private Boolean revoked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
