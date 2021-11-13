package com.purbasha.qms.dto;

import com.purbasha.qms.security.AuthoritiesConstants;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto extends AbstractAuditingDTO {

    private Long id;

    @Size(max = 100, min = 6)
    @NotBlank
    private String login;


    @Size(max = 100, min = 6)
    @NotBlank
    private String name;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    private boolean activate = true;

    private String authority = AuthoritiesConstants.OTHER;

    @Size(max = 15)
    private String phoneNumber;

    private Long clientId;
    private String clientName;


    private Long factoryId;
    private String factoryName;

    private Long factoryUnitId;
    private String factoryUnitName;
}
