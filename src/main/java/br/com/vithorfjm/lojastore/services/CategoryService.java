package br.com.vithorfjm.lojastore.services;

import br.com.vithorfjm.lojastore.domain.category.Category;
import br.com.vithorfjm.lojastore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategoryById(Long id) {
        Optional<Category> optCategory = this.repository.findById(id);
        if (optCategory.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        return optCategory.get();
    }

}
