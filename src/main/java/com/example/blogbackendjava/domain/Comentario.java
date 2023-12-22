package com.example.blogbackendjava.domain;

import com.example.blogbackendjava.dto.ComentarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name="comentarios")
@Entity(name="comentarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;
    private String texto;
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post posts;
    private Integer likes;
    private Boolean active;

    public Comentario(ComentarioRequestDTO data){
        this.users = data.users();
        this.texto = data.texto();
        this.posts = data.posts();
        this.likes = data.likes();
        this.active = true;
    }
}
