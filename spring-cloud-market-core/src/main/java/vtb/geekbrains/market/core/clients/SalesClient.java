package vtb.geekbrains.market.core.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.models.Sale;

import java.util.List;

//@FeignClient("sales")
public interface SalesClient {
    @GetMapping("/sales")
    public List<Sale> getAll();

    @GetMapping("/sale")
    public Sale getById(@RequestParam(name = "product_id") Long product_id,
                        @RequestParam(name = "customer_id") Long customer_id);

    @PostMapping("/sale")
    public Sale save(Sale sale);

    @DeleteMapping("/sale")
    void delete(Sale sale);
}



