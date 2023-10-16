package com.example.library.model.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Login {

    @ApiModelProperty(value = "Username" , notes = "Example : admin" , required = true)
    private String username;

    @ApiModelProperty(value = "Password" , notes = "Example : admin1234" , required = true)
    private String password;
}
