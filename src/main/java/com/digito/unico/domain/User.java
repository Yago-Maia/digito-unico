package com.digito.unico.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador do usuário", required = true)
    private Long id;

    @Column(name = "name", length=2048)
    @ApiModelProperty(notes = "Nome do usuário", required = true)
    @NotNull
    private String name;

    @Column(name = "email", length=2048)
    @ApiModelProperty(notes = "Email do usuário", required = true)
    @NotNull
    private String email;

    @OneToMany(mappedBy = "user_id")
    @ApiModelProperty(notes = "Lista de Dígitos Únicos do usuário", required = false)
    private List<UniqueDigit> uniqueDigitList;
}
