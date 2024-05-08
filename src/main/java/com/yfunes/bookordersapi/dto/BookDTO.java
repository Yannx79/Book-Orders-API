package com.yfunes.bookordersapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yfunes.bookordersapi.entities.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {

    private Integer idBook;

    @NotNull
    private String title;

    @NotNull
    private String authorName;

    @NotNull
    private String authorLastname;

    @NotNull
    private CategoryEnum categoryEnum;

}
