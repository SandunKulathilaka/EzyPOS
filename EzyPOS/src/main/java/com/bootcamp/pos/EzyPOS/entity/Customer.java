package com.bootcamp.pos.EzyPOS.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    /*{
        getClass().getName()+"@"+Integer.toHexString(hashCode())
    }*/
}
