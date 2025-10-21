package br.com.lab.project.dto.input;

import br.com.lab.project.model.Review;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateUserDTO(
        @NotNull @NotEmpty String name,
        @NotNull @NotEmpty String email,
        List<Review> reviews
)
{
}
