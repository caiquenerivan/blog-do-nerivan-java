package com.example.blogbackendjava.domain;

import com.example.blogbackendjava.dto.PostRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "posts")
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String titulo;
    private String subTitulo;
    private String capa;
    private String texto;
    @Enumerated(EnumType.STRING)
    private PostCategoria postCategoria;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;
    private String dataAtualizacao;
    private String horaAtualizacao;
    private Integer likes;
    @JsonIgnore
    @OneToMany(mappedBy = "posts")
    private List<Comentario> comentarios;
    public Boolean active;

    public Post(PostRequestDTO data){
        this.titulo = data.titulo();
        this.subTitulo = data.subTitulo();
        this.capa = data.capa();
        this.texto = data.texto();
        this.postCategoria = data.postCategoria();
        this.users = data.users();
        this.dataAtualizacao = LocalDate.now().toString();
        this.horaAtualizacao = LocalTime.now().toString();
        this.likes = data.likes();
        this.active = true;
    }

}