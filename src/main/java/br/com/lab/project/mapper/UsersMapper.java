package br.com.lab.project.mapper;

import br.com.lab.project.dto.input.CreateReviewDTO;
import br.com.lab.project.dto.input.CreateUserDTO;
import br.com.lab.project.model.Books;
import br.com.lab.project.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class UsersMapper {


    public Users fromCreateDtoToEntity(CreateUserDTO userRequestDto) {
        return new Users(
                userRequestDto.name(),
                userRequestDto.email(),
                new ArrayList<>()
        );

    }



}
