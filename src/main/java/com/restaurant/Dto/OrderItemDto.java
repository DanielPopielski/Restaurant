package com.restaurant.Dto;

import com.restaurant.Entity.DishEntity;
import com.restaurant.Entity.OrderEntity;
import com.restaurant.Entity.OrderItemEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link OrderItemEntity} entity
 */
@Data
public record OrderItemDto(OrderEntity order, DishEntity dish, int quantity) implements Serializable {
}