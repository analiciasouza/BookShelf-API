package br.com.lab.project.service;


import br.com.lab.project.model.Review;
import br.com.lab.project.repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {
    private final ReviewsRepository reviewsRepository;

    public ReviewService(ReviewsRepository reviewsRepository){
        this.reviewsRepository = reviewsRepository;
    }

    public Review createReview(Review review){
        return reviewsRepository.save(review);
    }

    public List<Review> getAllReviews(){
        return reviewsRepository.findAll();
    }

    public Optional<Review> getReviewById(UUID id){
        return reviewsRepository.findById(id);
    }

    public Review updateReview(UUID id, Review newReview){
        return reviewsRepository.findById(id).map(
                review -> {
                    review.setTextReview(newReview.getTextReview());
                    review.setRating(newReview.getRating());
                    return reviewsRepository.save(review);
                }
        ).orElseThrow(() -> new RuntimeException(("Review nao encontrada")));
    }

    public void deleteReview(UUID id){
        reviewsRepository.deleteById(id);
    }



}
