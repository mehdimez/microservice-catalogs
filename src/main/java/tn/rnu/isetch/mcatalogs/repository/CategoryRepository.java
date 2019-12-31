package tn.rnu.isetch.mcatalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.isetch.mcatalogs.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
