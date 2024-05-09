package com.yfunes.bookordersapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yfunes.bookordersapi.entities.BookEntity;
import com.yfunes.bookordersapi.entities.CustomerEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private Integer idOrder;

    @JsonBackReference
    private CustomerDTO customer;

    @NotNull
    private BookDTO book;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    private LocalDate orderDate;

}
