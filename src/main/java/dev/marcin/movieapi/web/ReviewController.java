package dev.marcin.movieapi.web;

import dev.marcin.movieapi.review.ReviewDto;
import dev.marcin.movieapi.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final static String LOCATION = "localhost:8080/api/v1/movies/%s";

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        String movieImdb = reviewDto.getMovieImdb();
        return ResponseEntity.created(URI.create(String.format(LOCATION, movieImdb)))
                .body(reviewService.createReview(reviewDto.getBody(), movieImdb));
    }
}
