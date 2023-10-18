package com.detyra.mvc.domain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineDTO extends BaseDomainDTO{
    private Integer id;
    @NotNull(message = "Power cannot be empty")
   // @Min(100)
    private Integer power;
    @NotBlank(message = "Engine type is required.")
    private String type;
}
