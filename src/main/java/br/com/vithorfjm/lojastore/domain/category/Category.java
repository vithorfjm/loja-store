package br.com.vithorfjm.lojastore.domain.category;

import jakarta.persistence.*;

@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
