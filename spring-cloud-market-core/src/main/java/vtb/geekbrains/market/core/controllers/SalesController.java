package vtb.geekbrains.market.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.clients.SalesClient;
import vtb.geekbrains.market.core.models.Sale;

@Controller
public class SalesController {
    //@Autowired
    SalesClient salesClient;

    @GetMapping("/sales")
    public String getSales(Model model) {
        model.addAttribute("sales", this.salesClient.getAll());
        return "sales";
    }

    @GetMapping("/sale/new")
    public String getSaleCreate(Model model) {
        model.addAttribute("sale", new Sale());
        return "salesCreate";
    }

    @PostMapping(value = "/sale/new", params = "action=create")
    public String postSaleCreate(Sale sale) {
        this.salesClient.save(sale);
        return "redirect:/sales";
    }

    @GetMapping("/sale")
    public String getSale(Model model, Sale.Id id) {
        try {
            Sale sale = this.salesClient.getById(id.getProduct_id(), id.getCustomer_id());
            model.addAttribute("sale", sale);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "salesEdit";
    }

    @PostMapping(value = "/sale/edit", params = "action=delete")
    public String deleteSale(@ModelAttribute Sale sale) {
        this.salesClient.delete(sale);
        return "redirect:/sales";
    }

    @PostMapping(value = "/sale/edit", params = "action=save")
    public String saveSale(Sale sale) {
        this.salesClient.save(sale);
        return "redirect:/sales";
    }
}
