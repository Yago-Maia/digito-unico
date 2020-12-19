package com.digito.unico.dto;

import com.digito.unico.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.Lob;
import java.io.Serializable;
import java.sql.Blob;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniqueDigitDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Nullable
    private Long id;

    private String n;

    @JsonIgnore
    @Lob
    private Blob nBlob;

    private Integer k;

    private int result;

    private User user;
}
