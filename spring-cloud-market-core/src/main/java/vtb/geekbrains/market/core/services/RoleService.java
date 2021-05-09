package vtb.geekbrains.market.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vtb.geekbrains.market.core.models.User;
import vtb.geekbrains.market.core.repositories.UserRepo;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAll() {
        return this.userRepo.findAll();
    }
}