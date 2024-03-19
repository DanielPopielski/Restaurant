package com.restaurant.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.restaurant.Entity.DishEntity} entity
 */
@Data
public record DishDto(String nameOfTheDish, String priceOfTheDish) implements Serializable {
}