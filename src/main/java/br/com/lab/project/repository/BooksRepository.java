package br.com.lab.project.repository;

import br.com.lab.project.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BooksRepository extends JpaRepository<Books, UUID> {


}
