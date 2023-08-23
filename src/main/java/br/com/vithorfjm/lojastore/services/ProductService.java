package br.com.vithorfjm.lojastore.services;

import br.com.vithorfjm.lojastore.domain.product.ProductDTO;
import br.com.vithorfjm.lojastore.domain.category.Category;
import br.com.vithorfjm.lojastore.domain.product.Product;
import br.com.vithorfjm.lojastore.repositories.ProductRepository;
import br.com.vithorfjm.lojastore.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public Product createProduct(ProductDTO data) {
        Category category = categoryService.getCategoryById(data.category_id());
        Product newProduct = new Product();
        newProduct.setName(data.name());
        newProduct.setPrice(data.price());
        newProduct.setDescription(data.description());
        newProduct.setCategory(category);
        this.repository.save(newProduct);
        return newProduct;
    }

    @Transactional
    public void updateProduct(ProductDTO data) {
        Product product = repository.findById(data.id()).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Category category = categoryService.getCategoryById(data.category_id());
        product.setName(data.name());
        product.setCategory(category);
        product.setDescription(data.description());
        product.setPrice(data.price());
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        repository.delete(product);
    }
}
