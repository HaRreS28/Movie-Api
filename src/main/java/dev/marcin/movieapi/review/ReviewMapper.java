package dev.marcin.movieapi.review;

public class ReviewMapper {

    public static ReviewDto map(Review review) {
        return new ReviewDto(review.getBody());
    }
}
