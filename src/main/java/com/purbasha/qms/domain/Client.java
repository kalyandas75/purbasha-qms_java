package com.purbasha.qms.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(
        name = "client",
        uniqueConstraints = @UniqueConstraint(columnNames={"name"}))
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Client extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}
