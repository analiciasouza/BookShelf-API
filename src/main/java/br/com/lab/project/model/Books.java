package br.com.lab.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "Books")
public class Books {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)

    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    private String genre;
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;


    public Books(UUID id, String title, String genre, String author, List<Review> reviews){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.reviews = reviews;

    }

    public Books(){

    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public List<Review> getReviews(){
        return reviews;
    }





}
