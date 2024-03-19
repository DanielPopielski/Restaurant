package com.restaurant.Dto;

import com.restaurant.Entity.TableEntity;
import com.restaurant.Entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link UserEntity} entity
 */
@Data
public record UserDto(String username, String password, String role,
                      List<TableEntity> tables) implements Serializable {
}