package com.restaurant.Dto;


import com.restaurant.Entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class TableDto {

    private long tableId;
    private long numberOfChairs;
    private List<UserEntity> users;
}
