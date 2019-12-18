package com.technokratos.demo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
public class TestEntity {

    @Id
    private Integer id;

}
