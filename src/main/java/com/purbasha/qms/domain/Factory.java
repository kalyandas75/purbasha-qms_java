package com.purbasha.qms.domain;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Entity
@Table(
        name = "factory",
        uniqueConstraints = @UniqueConstraint(columnNames={"name", "client_id"})
)
@Inheritance(strategy = InheritanceType.JOINED)
@FilterDef(name = "CLIENT_FILTER", parameters = {@ParamDef(name = "clientId", type = "long")})
@Filter(name = "CLIENT_FILTER", condition = "client_id = :clientId")
@Data
public class Factory extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "gstin", length = 50)
    private String gstin;

    @ManyToOne(optional = false)
    private Client client;
}
