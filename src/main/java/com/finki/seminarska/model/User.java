package com.finki.seminarska.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String first_name;

    private String last_name;

    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private List<Posts> my_posts;
    @OneToMany
    private List<Posts> liked;

    public User() {
    }

    public User(String username, String first_name, String last_name, String email) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public User(String username, String first_name, String last_name, String email, List<Posts> my_posts, List<Posts> liked) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = Role.ROLE_USER;
        this.my_posts = my_posts;
        this.liked = liked;
    }
}
