package vtb.geekbrains.market.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vtb.geekbrains.market.core.services.RoleService;

@Controller
@RequestMapping(value = "/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public String getSales(Model model) {
        model.addAttribute("roles", this.roleService.getAll());
        return "roles";
    }
}
