package com.greethy.account.infrastructure.config.component;

import com.greethy.account.application.rest.handler.model.request.RegisterUserRequest;
import com.greethy.account.domain.message.command.RegisterUserCommand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RequestCommandMapper {

    RegisterUserCommand toCommand(RegisterUserRequest request);

}
