package inv.test.pruebaspring.Repositories;

import inv.test.pruebaspring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Serializable> { }
