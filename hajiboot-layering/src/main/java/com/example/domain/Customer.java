package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by joony on 2016. 3. 17..
 */

@Data
@AllArgsConstructor //모든 필드를 인자로 받는 생성자
@NoArgsConstructor

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
