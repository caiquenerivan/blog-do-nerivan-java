package com.example.blogbackendjava.domain;

import com.example.blogbackendjava.dto.UserRequestDto;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Table(name="users")
@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String nickname;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String about;
    private String linkedin;
    private String twitter;
    private String instagram;
    private Boolean active;

    public User(UserRequestDto data){
        this.name = data.name();
        this.nickname = data.nickname();
        this.email = data.email();
        this.password = data.password();
        this.userType = data.userType();
        this.about = data.about();
        this.linkedin = data.linkedin();
        this.twitter = data.twitter();
        this.instagram = data.instagram();
        this.active = true;
    }
}
