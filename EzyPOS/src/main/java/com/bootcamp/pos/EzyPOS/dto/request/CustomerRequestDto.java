package com.bootcamp.pos.EzyPOS.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data // @ToString, @Setter, @Getter, hashcode, equals
public class CustomerRequestDto {
    private String name;
    private String address;
    private double salary;
}
