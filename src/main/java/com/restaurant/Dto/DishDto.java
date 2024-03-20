package com.restaurant.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DishDto {

    private long dishId;
    private String nameOfTheDish;
    private String priceOfTheDish;
}
