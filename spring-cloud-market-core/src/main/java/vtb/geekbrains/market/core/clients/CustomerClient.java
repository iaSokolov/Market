package vtb.geekbrains.market.core.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vtb.geekbrains.market.core.models.Customer;

import java.util.List;

@FeignClient("customer")
public interface CustomerClient {
    @GetMapping("/customer")
    public List<Customer> getAll();

    @GetMapping("/customer/{id}")
    public Customer getById(@PathVariable(value = "id") Long customerId);

    @PostMapping("/customer")
    public Customer save(Customer customer);

    @DeleteMapping("/customer")
    void delete(Customer customer);
}



