package com.luisfelipebp.model.DTO;

import com.luisfelipebp.model.RoleEnum;

public record RegisterDTO( String login, String password, String email, RoleEnum role) {
}
