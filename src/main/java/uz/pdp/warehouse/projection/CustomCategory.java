package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory{
    Integer getId();



    String getName();
    boolean getActive();
    Category getParentCategory();

}
