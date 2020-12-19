package com.digito.unico.mapper;

import com.digito.unico.domain.UniqueDigit;
import com.digito.unico.dto.UniqueDigitDTO;
import com.digito.unico.mapper.property.UniqueDigitDTOPropertyMap;
import com.digito.unico.mapper.property.UniqueDigitPropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UniqueDigitMapper extends Mapper<UniqueDigit, UniqueDigitDTO> {

    @PostConstruct
    public void configure() {
        modelMapper.addMappings(new UniqueDigitPropertyMap());
        modelMapper.addMappings(new UniqueDigitDTOPropertyMap());
    }
}
