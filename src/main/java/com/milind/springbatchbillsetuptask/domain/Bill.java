package com.milind.springbatchbillsetuptask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bill {

    public Bill(){
        super();
    }

    private Long Id;
    private String firstName;
    private String lastName;
    private Long dataUsage;
    private Long mins;
    private Double billAmount;
}
