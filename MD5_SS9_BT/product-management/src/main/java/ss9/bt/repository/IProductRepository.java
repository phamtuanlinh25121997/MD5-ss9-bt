package ss9.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ss9.bt.model.Product;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
