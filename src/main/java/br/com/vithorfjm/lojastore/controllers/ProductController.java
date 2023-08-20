package br.com.vithorfjm.lojastore.controllers;

import br.com.vithorfjm.lojastore.domain.product.ProductDTO;
import br.com.vithorfjm.lojastore.domain.product.Product;
import br.com.vithorfjm.lojastore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO data) {
        Product product = productService.createProduct(data);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO data) {
        productService.updateProduct(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
