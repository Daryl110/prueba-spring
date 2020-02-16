package inv.test.pruebaspring.Repositories;

import inv.test.pruebaspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Serializable> { }
