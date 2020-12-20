package com.digito.unico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniqueDigitDTO {

    @Nullable
    private Long id;

    private String n;

    private Integer k;

    private int result;

    private Long userId;
}
