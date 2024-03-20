package com.restaurant.Dto;

import com.restaurant.Entity.OrderItemEntity;
import com.restaurant.Entity.TableEntity;
import com.restaurant.Entity.UserEntity;
import com.restaurant.Enum.OrderStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.restaurant.Entity.OrderEntity} entity
 */
public record OrderDto(UserEntity user, TableEntity table, List<OrderItemEntity> orderItems, OrderStatusEnum status) implements Serializable {
}