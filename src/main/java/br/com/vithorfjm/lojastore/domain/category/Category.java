package br.com.vithorfjm.lojastore.domain.category;

import jakarta.persistence.*;

@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
}
