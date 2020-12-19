package com.digito.unico.web.controller;

import com.digito.unico.domain.UniqueDigit;
import com.digito.unico.dto.UniqueDigitDTO;
import com.digito.unico.service.UniqueDigitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/digitoUnico")
public class UniqueDigitController {
    @Autowired
    private UniqueDigitService uniqueDigitService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/calcula")
    public int computeUniqueDigit(HttpServletRequest request, @RequestBody UniqueDigitDTO uniqueDigitDto) throws SQLException {
        try {
            Long userId = request.getHeader("userId") == null ||
                    request.getHeader("userId").isEmpty() ? null : Long.valueOf(request.getHeader("userId"));

            return uniqueDigitService.computeAndSaveUniqueDigit(modelMapper.map(uniqueDigitDto, UniqueDigit.class), userId);
        } catch (Exception ex) {
            throw ex;
        }

    }

    @ApiOperation(value = "Lista Dígitos Únicos do usuário", notes = "Lista Dígitos Únicos do usuário", response = UniqueDigit.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dígitos Únicos Listados com sucesso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @GetMapping("/listar")
    public List<UniqueDigitDTO> listUniqueDigit(@RequestHeader("userId") Long userId) {
        try {
            return uniqueDigitService.getAllByUser(userId).stream().map(uniqueDigit -> modelMapper.map(uniqueDigit, UniqueDigitDTO.class)).collect(Collectors.toList());
        } catch (Exception ex) {
            throw ex;
        }
    }

}
