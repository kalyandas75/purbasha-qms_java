package com.purbasha.qms.domain;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Entity
@Table(
        name = "factory_unit",
        uniqueConstraints = @UniqueConstraint(columnNames={"name", "factory_id", "client_id"})
)
@Inheritance(strategy = InheritanceType.JOINED)
@FilterDef(name = "CLIENT_FILTER", parameters = {@ParamDef(name = "clientId", type = "long")})
@Filter(name = "CLIENT_FILTER", condition = "client_id = :clientId")
@Data
public class FactoryUnit extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Factory factory;

    @ManyToOne(optional = false)
    private Client client;
}
