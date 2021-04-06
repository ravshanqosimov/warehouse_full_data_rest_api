package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.Input;
import uz.pdp.warehouse.entity.InputProduct;

import java.util.Date;

@Projection(types = InputProduct.class)
public interface CustomIP {
    Integer getId();

    Integer getProductId();

    Double getAmount();

    Double getPrice();

    Date getExpireDate();

    Input getInput();

}
