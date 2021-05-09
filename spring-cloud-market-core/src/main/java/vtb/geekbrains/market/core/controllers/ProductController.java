package vtb.geekbrains.market.core.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.clients.ProductClient;
import vtb.geekbrains.market.core.models.Product;

@Data
@Controller
public class ProductController {
    @Autowired
    private ProductClient productClient;

    @GetMapping("/product")
    public String getProduct(Model model,
                             @RequestParam(name = "search", required = false) String search,
                             @RequestParam(name = "page", required = false) String page) {

        model.addAttribute("productList", productClient.getAll());
        return "product";
    }

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable(value = "id") Long productId) {
        Product product = this.productClient.getById(productId);
        model.addAttribute("product", product);
        return "productEdit";
    }

    @GetMapping("/product/new")
    public String getProductCreate(Model model) {
        model.addAttribute("product", new Product());
        return "productCreate";
    }

    @PostMapping(value = "/product/new", params = "action=create")
    public String postProductCreate(Product product) {
        this.productClient.save(product);
        return "redirect:/product";
    }

    @PostMapping(value = "/product/edit", params = "action=delete")
    public String deleteProduct(@ModelAttribute Product product) {
        this.productClient.delete(product);
        return "redirect:/product";
    }

    @PostMapping(value = "/product/edit", params = "action=save")
    public String saveProduct(Product product) {
        this.productClient.save(product);
        return "redirect:/product";
    }


//    @GetMapping("/searchProduct")
//    public String getSearchProduct(Model model) {
//        model.addAttribute("search", new SearchProduct());
//        return "searchProduct";
//    }
//
//    @PostMapping("/searchProduct")
//    public String postSearchProduct(Model model, @ModelAttribute SearchProduct search) {
//        model.addAttribute("search", search);
//        model.addAttribute("productList", productService.search(search));
//        return "searchProduct";
//    }
//
//    @GetMapping("/product/{id}")
//    public String getProduct(Model model, @PathVariable(value = "id") Long productId) {
//        Product product = this.productService.getById(productId);
//        model.addAttribute("product", product);
//        return "productEdit";
//    }
//

//
}
