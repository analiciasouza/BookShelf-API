package br.com.lab.project.mapper;

import br.com.lab.project.dto.input.CreateBookDTO;
import br.com.lab.project.dto.input.CreateReviewDTO;
import br.com.lab.project.model.Books;
import br.com.lab.project.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review fromCreateDtoToEntity(CreateReviewDTO reviewRequestDto) {
        return new Review(
                reviewRequestDto.textReview(),
                reviewRequestDto.rating(),
                reviewRequestDto.user(),
                reviewRequestDto.book()

        );


    }

}
