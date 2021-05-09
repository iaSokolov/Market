package vtb.geekbrains.market.product.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.product.models.Product;
import vtb.geekbrains.market.product.services.ProductService;

import java.util.List;

@RestController
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

    @GetMapping("me")
    public String getMe() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}