package br.com.lab.project.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)

    private UUID id;

    private String textReview;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "books_id")
    private Books book;

    public Review( String textReview, int rating, Users user, Books book){
        this.textReview = textReview;
        this.rating = rating;
        this.user = user;
        this.book = book;

    }


    public Review(UUID id, String textReview, int rating, Users user, Books book){
        this.id = id;
        this.textReview = textReview;
        this.rating = rating;
        this.user = user;
        this.book = book;

    }

    public Review(){

    }


    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getTextReview(){
        return textReview;
    }

    public void setTextReview(String textReview){
        this.textReview = textReview;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public Users getUser(){
        return user;
    }

    public void setUser(Users user){
        this.user = user;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }




}
