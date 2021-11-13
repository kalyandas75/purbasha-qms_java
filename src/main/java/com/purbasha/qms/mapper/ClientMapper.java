package com.purbasha.qms.mapper;

import com.purbasha.qms.domain.Client;
import com.purbasha.qms.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDto, Client> {
}
