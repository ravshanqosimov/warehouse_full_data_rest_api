package uz.pdp.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.warehouse.entity.OutputProduct;
import uz.pdp.warehouse.projection.CustomOP;

@RepositoryRestResource(path = "outputproduct",excerptProjection = CustomOP.class)
public interface OuputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
