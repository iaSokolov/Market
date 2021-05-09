package vtb.geekbrains.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtb.geekbrains.market.core.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
}