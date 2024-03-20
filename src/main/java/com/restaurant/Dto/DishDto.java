package com.restaurant.Dto;


import java.io.Serializable;

/**
 * A DTO for the {@link com.restaurant.Entity.DishEntity} entity
 */
public record DishDto(String nameOfTheDish, String priceOfTheDish) implements Serializable {
}