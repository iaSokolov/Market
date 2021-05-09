package vtb.geekbrains.market.core.controllers;

import lombok.Data;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vtb.geekbrains.market.core.models.User;

@Data
@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = new User();
        user.setName(username);
        model.addAttribute("user", user);
        return "index";
    }
}
