package com.digito.unico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "unique_digit")
public class UniqueDigit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificação do Dígito Único", required = true)
    private Long id;

    @ApiModelProperty(notes = "Valor N", required = true)
    @Transient
    private String n;

    @JsonIgnore
    @Column(name="n")
    @Lob
    @NotNull
    private Blob nBlob;

    @ApiModelProperty(notes = "Valor K", required = true)
    @NotNull
    private Integer k;

    @ApiModelProperty(notes = "Resultado", required = true)
    @NotNull
    private int result;

    @NotNull
    @ApiModelProperty(notes = "Identificador do usuário", required = false)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
