package vtb.geekbrains.market.core.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.models.Product;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/api/product")
    public List<Product> getAll();

    @GetMapping("/api/product/{id}")
    public Product getById(@PathVariable(value = "id") Long productId);

    @PostMapping("/api/product")
    public Product save(Product product);

    @DeleteMapping("/api/product")
    void delete(Product product);
}