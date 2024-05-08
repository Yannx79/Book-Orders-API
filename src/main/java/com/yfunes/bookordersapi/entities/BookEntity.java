package com.yfunes.bookordersapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBook;

    @Column(length = 60)
    private String title;

    @Column(length = 60)
    private String authorName;

    @Column(length = 60)
    private String authorLastname;

    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

}
