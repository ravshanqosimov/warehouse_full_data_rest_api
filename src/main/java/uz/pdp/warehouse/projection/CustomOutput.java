package uz.pdp.warehouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.warehouse.entity.Client;
import uz.pdp.warehouse.entity.Currency;
import uz.pdp.warehouse.entity.Output;
import uz.pdp.warehouse.entity.Warehouse;

import java.util.Date;

@Projection(types = Output.class)
public interface CustomOutput {
    Integer getId();
    Date getDate();
    Warehouse getWarehouse();
    Currency getCurrency();
    String getFactureNumber();
    String getCode();
    Client getClient();

}
