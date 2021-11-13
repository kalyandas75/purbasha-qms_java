package com.purbasha.qms.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class FactoryDto extends AbstractAuditingDTO {
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String name;
    @Size(max = 255)
    private String address;
    @Size(max = 50)
    private String gstin;

    private Long clientId;
    private String clientName;
}
