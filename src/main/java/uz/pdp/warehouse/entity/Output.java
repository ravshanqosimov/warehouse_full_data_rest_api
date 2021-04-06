package uz.pdp.warehouse.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehouse.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Output extends AbsEntity {
    private Date date;
    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Currency currency;
    private String factureNumber;
    private String code;

    @ManyToOne
    private Client client;

}
