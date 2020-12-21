package com.digito.unico.web.controller;

import com.digito.unico.domain.User;
import com.digito.unico.dto.UserDTO;
import com.digito.unico.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Lista o usuário", notes = "Lista o usuário", response = UserDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário Listado com sucesso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @GetMapping(value = { "/{id}" })
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(modelMapper.map(userService.findById(id), UserDTO.class));
        } catch (Exception ex) {
            throw ex;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Exclui um Usuário", notes = "Exclui um Usuário")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Exclusão com sucesso de um usuário"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @DeleteMapping(value = { "/{id}" })
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(userService.deleteUser(id));
        } catch (Exception ex) {
            throw ex;
        }

    }

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insere um Usuário com Dígito Único", notes = "Insere um Usuário com Dígito Único", response = UserDTO.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Inclusão do Usuário com sucesso."),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @PostMapping
    public ResponseEntity<UserDTO> saveUSer(@RequestBody UserDTO userDto, @RequestHeader("publicKey") String publicKey) {
        try {
            User user = modelMapper.map(userDto, User.class);
            return ResponseEntity.ok().body(modelMapper.map(userService.save(user, publicKey), UserDTO.class));
        } catch (Exception ex) {
            throw ex;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza Usuário", notes = "Atualiza Usuário")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Atualização com sucesso de um usuário"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @PutMapping
    public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDto, @RequestHeader("publicKey") String publicKey) {
        try {
            User user = modelMapper.map(userDto, User.class);
            return ResponseEntity.ok().body(modelMapper.map(userService.update(user, publicKey), UserDTO.class));
        } catch (Exception ex) {
            throw ex;
        }
    }

    @ApiOperation(value = "Lista todos os Usuários", notes = "Lista todos os Usuários", response = UserDTO.class, responseContainer = "List" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "Recurso proibido"),
            @ApiResponse(code = 404, message = "Recurso não encontrado") })
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllRatings() {
        try {
            return ResponseEntity.ok().body(
                    userService.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList()));
        } catch (Exception ex) {
            throw ex;
        }
    }
}
