package com.numble.webnovel.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SignInResultDto extends SignUpResultDto {
    private String token;
}
