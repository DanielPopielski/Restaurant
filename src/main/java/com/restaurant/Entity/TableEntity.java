package com.restaurant.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tables")
@Getter
@Setter
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private long tableId;

    @Column(name = "number_of_chairs")
    private long numberOfChairs;

    @ManyToMany(mappedBy = "tables")
    private List<UserEntity> users;
}
