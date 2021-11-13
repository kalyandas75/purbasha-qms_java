package com.purbasha.qms.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FactoryUnitDto extends AbstractAuditingDTO {
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    private Long factoryId;
    private String factoryName;

    private Long clientId;
    private String clientName;
}
