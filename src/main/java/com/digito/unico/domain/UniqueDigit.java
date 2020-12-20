package com.digito.unico.domain;

import com.digito.unico.exceptions.BlobConversionException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;

@Data
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

    @Column(name = "userId")
    @ApiModelProperty(notes = "Identificador do usuário", required = false)
    @NotNull
    private Long userId;

    public UniqueDigit(Long id, String n, Integer k, int result, Long userId) throws SQLException {
        this.id = id;
        this.n = n;
        this.nBlob = new SerialBlob(n.getBytes(StandardCharsets.UTF_8));
        this.k = k;
        this.result = result;
        this.userId = userId;
    }

    public String getN() {
        if(this.nBlob != null) {
            try {
                return new String(this.nBlob.getBytes(1l, (int) this.nBlob.length()));
            } catch (Exception e) {
                throw new BlobConversionException();
            }
        } else {
            return n;
        }
    }
}
