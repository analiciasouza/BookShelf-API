package br.com.lab.project.service;

import br.com.lab.project.model.Review;
import br.com.lab.project.model.Users;
import br.com.lab.project.repository.ReviewsRepository;
import br.com.lab.project.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
        private final UsersRepository usersRepository;

        public UserService(UsersRepository usersRepository){
            this.usersRepository = usersRepository;
        }

        public Users createUser(Users user){
            return usersRepository.save(user);
        }

        public List<Users> getAllUsers(){
            return usersRepository.findAll();
        }

        public Optional<Users> getUserById(UUID id){
            return usersRepository.findById(id);
        }

        public Users updateUser(UUID id, Users newUser){
            return usersRepository.findById(id).map(
                    users -> {
                        users.setName(newUser.getName());
                        users.setEmail(newUser.getEmail());
                        return usersRepository.save(users);
                    }
            ).orElseThrow(() -> new RuntimeException(("Usuario nao encontrada")));
        }

        public void deleteUser(UUID id){
            usersRepository.deleteById(id);
        }




    }

