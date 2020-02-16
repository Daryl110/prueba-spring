package inv.test.pruebaspring.Controllers;

import inv.test.pruebaspring.Services.CategoryService;
import inv.test.pruebaspring.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Category category){
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.OK);
    }
}
