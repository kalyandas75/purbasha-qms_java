package com.purbasha.qms.mapper;

import com.purbasha.qms.domain.FactoryUnit;
import com.purbasha.qms.dto.FactoryUnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, FactoryMapper.class })
public interface FactoryUnitMapper extends EntityMapper<FactoryUnitDto, FactoryUnit> {

    @Mappings({
            @Mapping(target = "client.id", source = "clientId"),
            @Mapping(target = "factory.id", source = "factoryId")
    })
    FactoryUnit toEntity(FactoryUnitDto dto);

    @Mappings({
            @Mapping(target = "clientId", source = "client.id"),
            @Mapping(target = "clientName", source = "client.id"),
            @Mapping(target = "factoryId", source = "factory.id"),
            @Mapping(target = "factoryName", source = "factory.id"),
    })
    FactoryUnitDto toDto(FactoryUnit entity);
}
