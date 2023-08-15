package br.com.vithorfjm.lojastore.repositories;

import br.com.vithorfjm.lojastore.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
