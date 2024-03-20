package com.restaurant.Dto;

import com.restaurant.Entity.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.restaurant.Entity.TableEntity} entity
 */
public record TableDto(List<UserEntity> users) implements Serializable {
}