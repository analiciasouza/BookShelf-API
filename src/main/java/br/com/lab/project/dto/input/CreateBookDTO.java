package br.com.lab.project.dto.input;

import br.com.lab.project.model.Review;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateBookDTO (
    @NotNull @NotEmpty String title,
    @NotNull @NotEmpty String genre,
    @NotNull @NotEmpty String author,
    List<Review> reviews )

{

}
