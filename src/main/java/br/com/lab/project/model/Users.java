package br.com.lab.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "users")
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, updatable = false, nullable = false)

    private UUID id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;



    public Users(String name, String email, List<Review> reviews){
        this.name = name;
        this.email = email;
        this.reviews = reviews;
    }


    public Users(UUID id, String name, String email, List<Review> reviews){
        this.id = id;
        this.name = name;
        this.email = email;

        this.reviews = reviews;
    }

    public Users(){

    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Review> getReviews(){
        return reviews;
    }

}
