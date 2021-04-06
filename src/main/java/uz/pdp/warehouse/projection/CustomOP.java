package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.Output;
import uz.pdp.warehouse.entity.OutputProduct;
import uz.pdp.warehouse.entity.Product;

@Projection(types = OutputProduct.class)
public interface CustomOP {

    Integer getId();

    Product getProduct();

    Double getAmount();

    Double getPrice();

    Output getOutput();

}
