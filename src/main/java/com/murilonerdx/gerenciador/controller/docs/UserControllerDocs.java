package com.murilonerdx.gerenciador.controller.docs;

import com.murilonerdx.gerenciador.dto.UserDTO;
import com.murilonerdx.gerenciador.entity.request.UserRequestDTO;
import com.murilonerdx.gerenciador.exceptions.EmailNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Users management")
public interface UserControllerDocs {

    @ApiOperation(value = "User creation operation")
    @ApiResponses(
            value =
                    {
                            @ApiResponse(code = 201, message = "Success user creation")
                            , @ApiResponse(
                            code = 400,
                            message =
                                    "Missing required fields, wrong field range value or user already registered on system")
                    })
    ResponseEntity<UserDTO>
    create(UserRequestDTO userRequestDTO);

    @ApiOperation(value = "Find user by e-mail operation")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Success user found")
                    , @ApiResponse(code = 404,
                    message = "User not found error code")
            })
    ResponseEntity<UserDTO>
    findByEmail(String email) throws EmailNotFoundException;

    @ApiOperation(value = "List all registered users")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200,
                            message = "Return all registered users")
            })
    ResponseEntity<List<UserDTO>>
    findAll();

    @ApiOperation(value = "Delete user by id operation")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 204, message = "Success user deleted")
                    , @ApiResponse(code = 404,
                    message = "User not found error code")
            })
    ResponseEntity<?> delete(Long id);


    @ApiOperation(value = "Update user by id operation")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 204, message = "Success user updated user")
                    , @ApiResponse(code = 404,
                    message = "Missing required fields, wrong field range value or user already registered on system")
            })
    ResponseEntity<UserDTO>
    update(Long id, UserRequestDTO userRequestDTO);


    @ApiOperation(value = "Find user by id operation")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 204, message = "Success user find user")
                    , @ApiResponse(code = 404,
                    message = "\"User not found error code")
            })
    ResponseEntity<UserDTO>
    findById(Long id, UserRequestDTO userRequestDTO);
}