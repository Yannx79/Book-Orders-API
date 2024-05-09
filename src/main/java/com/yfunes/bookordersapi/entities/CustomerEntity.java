package com.yfunes.bookordersapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCustomer;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String lastname;

    @Column(length = 60)
    private String address;

    @Column(length = 60)
    private String city;

    @Column(length = 60)
    private String country;

    @Column(length = 12)
    private String phone;

    @Column(length = 8)
    private String dni;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orderList;

}
