package vtb.geekbrains.market.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.clients.CustomerClient;
import vtb.geekbrains.market.core.models.Customer;

@Controller
public class CustomerController {
    @Autowired
    CustomerClient customerClient;

    @GetMapping("/customer")
    public String getCustomer(Model model,
                              @RequestParam(name = "search", required = false) String search,
                              @RequestParam(name = "page", required = false) String page) {

        model.addAttribute("customers", customerClient.getAll());
        return "customer";
    }

    @GetMapping("/customer/{id}")
    public String getCustomer(Model model, @PathVariable(value = "id") Long customerId) {
        Customer customer = this.customerClient.getById(customerId);
        model.addAttribute("customer", customer);
        return "customerEdit";
    }

    @GetMapping("/customer/new")
    public String getCustomerCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerCreate";
    }

    @PostMapping(value = "/customer/new", params = "action=create")
    public String postCustomerCreate(Customer customer) {
        this.customerClient.save(customer);
        return "redirect:/customer";
    }

    @PostMapping(value = "/customer/edit", params = "action=delete")
    public String deleteCustomer(@ModelAttribute Customer customer) {
        this.customerClient.delete(customer);
        return "redirect:/customer";
    }

    @PostMapping(value = "/customer/edit", params = "action=save")
    public String saveCustomer(Customer customer) {
        this.customerClient.save(customer);
        return "redirect:/customer";
    }
}
