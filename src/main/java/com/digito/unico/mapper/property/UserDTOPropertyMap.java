package com.digito.unico.mapper.property;

import com.digito.unico.domain.User;
import com.digito.unico.dto.UserDTO;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UserDTOPropertyMap extends PropertyMap<UserDTO, User> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setName(source.getName());
        map().setEmail(source.getEmail());
    }
}
