package com.digito.unico.mapper.property;

import com.digito.unico.domain.UniqueDigit;
import com.digito.unico.dto.UniqueDigitDTO;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UniqueDigitPropertyMap extends PropertyMap<UniqueDigit, UniqueDigitDTO> {

    @Override
    protected void configure() {
        map().setId(source.getId());
        map().setN(source.getN());
        map().setNBlob(source.getNBlob());
        map().setK(source.getK());
        map().setResult(source.getResult());
        map().setUser(source.getUser());
    }
}
