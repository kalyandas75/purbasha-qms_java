package com.purbasha.qms.domain;

import com.purbasha.qms.security.AuthoritiesConstants;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(
        name = "qms_user",
        uniqueConstraints = @UniqueConstraint(columnNames={"login", "client_id"})
)
@Inheritance(strategy = InheritanceType.JOINED)
@FilterDef(name = "CLIENT_FILTER", parameters = {@ParamDef(name = "clientId", type = "long")})
@Filter(name = "CLIENT_FILTER", condition = "client_id = :clientId")
@Data
public class User extends AbstractAuditingEntity  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "login", length = 100, nullable = false)
    private String login;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean activate = true;

    @Column(nullable = false, length = 21)
    private String authority = AuthoritiesConstants.OTHER;

    @Column(length = 15)
    private String phoneNumber;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Factory factory;

    @ManyToOne
    private FactoryUnit factoryUnit;

}
