package br.com.vithorfjm.lojastore.repositories;

import br.com.vithorfjm.lojastore.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
