package br.com.vithorfjm.lojastore.services;

import br.com.vithorfjm.lojastore.domain.product.ProductDTO;
import br.com.vithorfjm.lojastore.domain.category.Category;
import br.com.vithorfjm.lojastore.domain.product.Product;
import br.com.vithorfjm.lojastore.repositories.ProductRepository;
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
        Optional<Product> optProduct = this.repository.findById(id);
        if (optProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return optProduct.get();
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
        Optional<Product> optProduct = repository.findById(data.id());
        if (optProduct.isPresent()) {
            Category category = categoryService.getCategoryById(data.category_id());
            Product product = optProduct.get();
            product.setName(data.name());
            product.setCategory(category);
            product.setDescription(data.description());
            product.setPrice(data.price());
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void deleteProduct(Long id) {
        Optional<Product> optProduct = repository.findById(id);
        if (optProduct.isPresent()) repository.delete(optProduct.get());
        else throw new RuntimeException();
    }
}
