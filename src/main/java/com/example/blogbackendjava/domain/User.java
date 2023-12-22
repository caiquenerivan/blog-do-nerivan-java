package com.example.blogbackendjava.domain;

import com.example.blogbackendjava.dto.UserRequestDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

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
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Post> posts;
    @OneToMany(mappedBy = "users")
    private List<Comentario> comentarios;
    private Boolean active;

    public User(UserRequestDTO data){
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
