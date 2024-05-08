package com.yfunes.bookordersapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private BookEntity bookEntity;

    private Integer quantity;

    private LocalDate orderDate;

}
