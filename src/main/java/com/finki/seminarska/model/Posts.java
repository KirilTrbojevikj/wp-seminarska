package com.finki.seminarska.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    @OneToOne
    private Category category;
    @OneToOne
    private User created_by;

    private LocalDate date_created;

    public Posts() {
    }

    public Posts(Product product, Category category, User created_by, LocalDate date_created) {
        this.product = product;
        this.category = category;
        this.created_by = created_by;
        this.date_created = date_created;
    }
}
