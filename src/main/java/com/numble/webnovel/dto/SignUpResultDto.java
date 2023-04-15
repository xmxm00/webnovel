package com.numble.webnovel.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SignUpResultDto {
    private boolean success;
    private String msg;
}
