package com.restaurant.Dto;

import com.restaurant.Entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.restaurant.Entity.TableEntity} entity
 */
@Data
public record TableDto(List<UserEntity> users) implements Serializable {
}