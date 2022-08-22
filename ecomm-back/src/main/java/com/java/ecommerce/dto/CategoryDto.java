package com.java.ecommerce.dto;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    @NotNull(message = "ID should not equal null!")
    @PositiveOrZero(message = "Only positiv IDs!")
    @NaturalId
    private Long id;

    @NotBlank(message = "Category Name should not be blank")
    @Size(min = 3, message = "Category Name should be at least 3 chars")
    private String name;
//    private Set<Long> productsIDs;


}
