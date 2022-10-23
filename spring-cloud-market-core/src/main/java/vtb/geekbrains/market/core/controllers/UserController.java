package vtb.geekbrains.market.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vtb.geekbrains.market.core.models.Authority;
import vtb.geekbrains.market.core.models.NavBar;
import vtb.geekbrains.market.core.models.Role;
import vtb.geekbrains.market.core.models.User;
import vtb.geekbrains.market.core.repositories.AuthoritiesRepo;
import vtb.geekbrains.market.core.repositories.RoleRepo;
import vtb.geekbrains.market.core.services.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesRepo authoritiesRepo;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping
    public String getSales(Model model) {
        List<Authority> authorityList = authoritiesRepo.findAll();

        List<User> users = this.userService.getAll();

        List<Role> roles = this.roleRepo.findAll();

        model.addAttribute("users", this.userService.getAll());
        model.addAttribute("navBar", new NavBar("/users"));
        return "users";
    }
}
