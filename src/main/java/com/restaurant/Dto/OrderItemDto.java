package com.restaurant.Dto;

import com.restaurant.Entity.DishEntity;
import com.restaurant.Entity.OrderEntity;
import com.restaurant.Entity.OrderItemEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link OrderItemEntity} entity
 */
public record OrderItemDto(OrderEntity order, DishEntity dish, int quantity) implements Serializable {
}