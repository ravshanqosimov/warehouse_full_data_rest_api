package uz.pdp.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.warehouse.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Input extends AbsEntity {

    private Date date;
    @ManyToOne
    private Warehouse werhause;
    private Integer supplierId;

    @ManyToOne
    private Currency  currency;

    private Integer factureNumber;

    @Column(nullable = false,unique = true)
    private String code;

}
