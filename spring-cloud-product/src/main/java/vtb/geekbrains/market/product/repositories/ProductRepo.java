package vtb.geekbrains.market.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtb.geekbrains.market.product.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}