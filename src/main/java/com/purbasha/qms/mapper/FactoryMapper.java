package com.purbasha.qms.mapper;

import com.purbasha.qms.domain.Factory;
import com.purbasha.qms.dto.FactoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ClientMapper.class })
public interface FactoryMapper extends EntityMapper<FactoryDto, Factory> {

    @Mappings({
            @Mapping(target = "client.id", source = "clientId")
    })
    Factory toEntity(FactoryDto dto);

    @Mappings({
            @Mapping(target = "clientId", source = "client.id"),
            @Mapping(target = "clientName", source = "client.id"),
    })
    FactoryDto toDto(Factory entity);
}
