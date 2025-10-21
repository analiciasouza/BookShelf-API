package br.com.lab.project.dto.input;

import br.com.lab.project.model.Books;
import br.com.lab.project.model.Users;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateReviewDTO (
        @NotNull @NotEmpty String textReview,
        @NotNull @NotEmpty int rating,
        @NotNull @NotEmpty Users user,
        @NotNull @NotEmpty Books book
        )
{}
