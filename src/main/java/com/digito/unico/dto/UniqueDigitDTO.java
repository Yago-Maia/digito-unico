package com.digito.unico.dto;

import com.digito.unico.domain.User;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.sql.Blob;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniqueDigitDTO extends RepresentationModel<UniqueDigitDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String n;

    @JsonIgnore
    private Blob nBlob;

    private Integer k;

    private int result;

    private User user;
}
