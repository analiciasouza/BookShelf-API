package br.com.lab.project.service;

import br.com.lab.project.model.Books;
import br.com.lab.project.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public Books createBook(Books books){
        return  booksRepository.save(books);
    }

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Optional<Books> getBookById(UUID id){
        return booksRepository.findById(id);
    }

    public Books updateBook(UUID id, Books newBooks){
        return booksRepository.findById(id).map(
                books -> {
                    books.setTitle(newBooks.getTitle());
                    books.setGenre(newBooks.getGenre());
                    books.setAuthor(newBooks.getAuthor());
                    return booksRepository.save(books);
                }
        ).orElseThrow(() -> new RuntimeException(("Livro nao encontrado")));

    }

    public void deleteBook(UUID id){
        booksRepository.deleteById(id);
    }




}
