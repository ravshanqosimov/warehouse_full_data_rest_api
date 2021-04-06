package uz.pdp.warehouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.warehouse.entity.InputProduct;
import uz.pdp.warehouse.projection.CustomIP;

@RepositoryRestResource(path = "inputproduct",excerptProjection = CustomIP.class)
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}
