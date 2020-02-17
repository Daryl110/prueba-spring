package inv.test.pruebaspring.Services;

import inv.test.pruebaspring.Repositories.CategoryRepository;
import inv.test.pruebaspring.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        Category categoryCreated = this.categoryRepository.save(category);
        if (categoryCreated == null){
            throw new RuntimeException("the category can't created");
        }
        return categoryCreated;
    }

    public List<Category> listAll() {
        return this.categoryRepository.findAll();
    }
}
