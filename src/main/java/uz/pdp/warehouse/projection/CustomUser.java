package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.User;
import uz.pdp.warehouse.entity.Warehouse;

import java.util.Set;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    String getCode();

    String getPassword();

    boolean getActive();

    Set<Warehouse> getWarehouse();

}
