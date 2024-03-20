package com.restaurant.Dto;

import com.restaurant.Entity.TableEntity;
import com.restaurant.Entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link UserEntity} entity
 */
public record UserDto(String username, String password, String role,
                      List<TableEntity> tables) implements Serializable {
}