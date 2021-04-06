package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.Attachment;
import uz.pdp.warehouse.entity.Category;
import uz.pdp.warehouse.entity.Measurement;
import uz.pdp.warehouse.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getPhoto();

    String getCode();

    Measurement getMeasurement();

    boolean getActive();

}
