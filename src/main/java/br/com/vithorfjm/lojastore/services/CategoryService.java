package br.com.vithorfjm.lojastore.services;

import br.com.vithorfjm.lojastore.domain.category.Category;
import br.com.vithorfjm.lojastore.repositories.CategoryRepository;
import br.com.vithorfjm.lojastore.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategoryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

}
