package br.com.lab.project.controllers;

import br.com.lab.project.model.Review;
import br.com.lab.project.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    private final ReviewService reviewService;

    public ReviewsController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Review review){
        var reviewCreated = reviewService.createReview(review);
        URI location = URI.create("/api/v1/reviews" + reviewCreated.getId());
        return ResponseEntity.created(location).build();
    }


    // list all
    @GetMapping
    public ResponseEntity<List<Review>> getAll(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    // list by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getById(@PathVariable UUID id){
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable UUID id, @RequestBody Review review){
        return ResponseEntity.ok(reviewService.updateReview(id, review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
