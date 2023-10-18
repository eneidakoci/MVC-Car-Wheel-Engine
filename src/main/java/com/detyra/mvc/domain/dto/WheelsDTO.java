package com.detyra.mvc.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WheelsDTO extends BaseDomainDTO {
    private Integer id;
//    VALIDATIONS
    @NotBlank(message = "Wheel size is required.")
    private String size;
    @NotBlank(message = "Type cannot be empty.")
    private String type;
}
