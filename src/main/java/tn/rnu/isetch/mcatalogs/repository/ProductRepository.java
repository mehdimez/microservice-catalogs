package tn.rnu.isetch.mcatalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isetch.mcatalogs.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
