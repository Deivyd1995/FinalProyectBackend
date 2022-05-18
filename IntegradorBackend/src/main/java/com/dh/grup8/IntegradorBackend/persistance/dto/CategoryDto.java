package com.dh.grup8.IntegradorBackend.persistance.dto;

import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    @Schema(example = "Deptos", required = true)
    @NotBlank(message = "Title can't be blank")
    private String title;
    @Schema(example = "Default description from the category", required = true)
    @NotBlank(message = "Description can't be blank")
    private String description;
    @Schema(example = "https://server.com/depto_cancun.jpg", required = true)
    @NotBlank(message = "ImageURL can't be blank")
    private String urlImage;

    public CategoryDto() {
    }
}
