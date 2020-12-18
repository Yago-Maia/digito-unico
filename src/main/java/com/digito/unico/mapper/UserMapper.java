package com.digito.unico.mapper;

import com.digito.unico.domain.User;
import com.digito.unico.dto.UserDTO;
import com.digito.unico.mapper.property.UserDTOPropertyMap;
import com.digito.unico.mapper.property.UserPropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserMapper extends Mapper<User, UserDTO> {

    @PostConstruct
    public void configure() {
        modelMapper.addMappings(new UserPropertyMap());
        modelMapper.addMappings(new UserDTOPropertyMap());
    }
}
