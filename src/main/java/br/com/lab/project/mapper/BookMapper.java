package br.com.lab.project.mapper;

import br.com.lab.project.dto.input.CreateBookDTO;
import br.com.lab.project.dto.input.CreateReviewDTO;
import br.com.lab.project.model.Books;
import br.com.lab.project.model.Review;
import br.com.lab.project.model.Users;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public Books fromCreateDtoToEntity(CreateBookDTO booksRequestDto) {
        return new Books(
                booksRequestDto.title(),
                booksRequestDto.genre(),
                booksRequestDto.author(),
                new ArrayList<>()
        );


    }
    }





