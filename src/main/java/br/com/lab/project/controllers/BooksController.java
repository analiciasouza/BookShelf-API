package br.com.lab.project.controllers;


import br.com.lab.project.dto.input.CreateBookDTO;
import br.com.lab.project.mapper.BookMapper;
import br.com.lab.project.model.Books;
import br.com.lab.project.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BooksController(BookService bookService, BookMapper bookMapper){
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateBookDTO bookDTO){
        Books books = bookMapper.fromCreateDtoToEntity(bookDTO);
        var bookCreated = bookService.createBook(books);
        URI location = URI.create("/api/v1/books/" + bookCreated.getId());
        return ResponseEntity.created(location).build();
    }

    // read all
    @GetMapping
    public ResponseEntity<List<Books>> getAll(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }


    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Books>> getById(@PathVariable UUID id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> update(@PathVariable UUID id, @RequestBody Books books){
        return ResponseEntity.ok(bookService.updateBook(id, books));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
