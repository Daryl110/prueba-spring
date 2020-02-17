package inv.test.pruebaspring.Controllers;

import inv.test.pruebaspring.Services.ProductService;
import inv.test.pruebaspring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping(path = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listByCategory(@PathVariable int categoryId) {
        return new ResponseEntity<>(this.productService.listByCategory(categoryId), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);
    }
}
