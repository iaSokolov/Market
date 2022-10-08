package vtb.geekbrains.market.product.controllers;

import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.product.models.Product;
import vtb.geekbrains.market.product.services.ProductService;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class ProductController {
    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> getProductSet() {
        List<Product> productList = this.productService.getEntitySet();
        return productList;
    }

    @GetMapping("/product/{id}")
    public Product getProductEntity(@PathVariable(value = "id") Long productId) {
        return this.productService.getEntity(productId);
    }

    @PostMapping("/product")
    public void createProductEntity(@RequestBody Product product) {
        this.productService.createEntity(product);
    }

    @DeleteMapping("/product")
    public void deleteProductEntity(@RequestBody Product product) {
        this.productService.deleteEntity(product);
    }

    @PutMapping("/product")
    public void saveProductEntity(@RequestBody Product product) {
        this.productService.saveEntity(product);
    }
}