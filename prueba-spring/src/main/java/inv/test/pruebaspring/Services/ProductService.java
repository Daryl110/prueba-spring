package inv.test.pruebaspring.Services;

import inv.test.pruebaspring.Repositories.CategoryRepository;
import inv.test.pruebaspring.Repositories.ProductRepository;
import inv.test.pruebaspring.entities.Category;
import inv.test.pruebaspring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        List<Category> categories = this.categoryRepository.findAll();

        boolean found = false, isChild = true;

        for(Category category: categories){
            if (category.getId() == product.getCategory().getId()){
                found = !found;
            }
            if (category.getParentCategory() != null && category.getParentCategory().getId() == product.getCategory().getId()){
                isChild = false;
            }
        }

        if (!found) {
            throw new RuntimeException("the category not found");
        }

        if (!isChild) {
            throw new RuntimeException("the category isn't child");
        }

        Product productCreated = this.productRepository.save(product);

        if (productCreated == null) {
            throw new RuntimeException("the product can't create");
        }

        return productCreated;
    }
}
