package com.purbasha.qms.mapper;

import com.purbasha.qms.domain.User;
import com.purbasha.qms.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, FactoryMapper.class, FactoryUnitMapper.class })
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Mappings({
            @Mapping(target = "client.id", source = "clientId"),
            @Mapping(target = "factory.id", source = "factoryId"),
            @Mapping(target = "factoryUnit.id", source = "factoryUnitId")
    })
    User toEntity(UserDto dto);

    @Mappings({
            @Mapping(target = "clientId", source = "client.id"),
            @Mapping(target = "clientName", source = "client.id"),
            @Mapping(target = "factoryId", source = "factory.id"),
            @Mapping(target = "factoryName", source = "factory.id"),
            @Mapping(target = "factoryUnitId", source = "factoryUnit.id"),
            @Mapping(target = "factoryUnitName", source = "factoryUnit.id")
    })
    UserDto toDto(User entity);
}
