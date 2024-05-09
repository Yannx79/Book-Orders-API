package com.yfunes.bookordersapi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yfunes.bookordersapi.entities.OrderEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

    private Integer idCustomer;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    @Min(value = 12)
    private String phone;

    @NotNull
    @Min(value = 8)
    private String dni;

    @JsonManagedReference
    private List<OrderDTO> orderList;

}
