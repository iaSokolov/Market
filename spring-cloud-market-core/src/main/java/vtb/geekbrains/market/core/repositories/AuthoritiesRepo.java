package vtb.geekbrains.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtb.geekbrains.market.core.models.Authority;

@Repository
public interface AuthoritiesRepo extends JpaRepository<Authority, Authority.Id> {
}