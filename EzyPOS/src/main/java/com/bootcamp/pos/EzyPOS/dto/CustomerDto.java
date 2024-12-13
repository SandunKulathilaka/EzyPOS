package com.bootcamp.pos.EzyPOS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // @ToString, @Setter, @Getter, hashcode, equals
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private double salary;
}
