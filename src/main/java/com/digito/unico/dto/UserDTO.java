package com.digito.unico.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;
}
