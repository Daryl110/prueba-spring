package inv.test.pruebaspring.Services;

import inv.test.pruebaspring.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;
}
