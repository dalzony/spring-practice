package com.example.domain;

/**
 * Created by joony on 2016. 5. 31..
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private Integer id;
    private String fisrtName;
    private String lastName;
}
