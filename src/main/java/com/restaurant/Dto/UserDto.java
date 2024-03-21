package com.restaurant.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private long userId;
    private String username;
    private String password;
    private String role;
}
