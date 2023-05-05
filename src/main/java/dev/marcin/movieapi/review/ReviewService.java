package dev.marcin.movieapi.review;

import dev.marcin.movieapi.movie.Movie;
import dev.marcin.movieapi.movie.MovieRepository;
import dev.marcin.movieapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Transactional
    public ReviewDto createReview(String body, String imdbId) {
        Review review = new Review();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        review.setBody(body);
        review.setUser(userRepository.findByEmail(user).orElseThrow());
        reviewRepository.save(review);
        Movie movie = movieRepository.findByImdbId(imdbId).orElseThrow();
        movie.getReviewIds().add(review);
        movieRepository.save(movie);
        ReviewDto reviewDto = ReviewMapper.map(review);
        reviewDto.setMovieImdb(imdbId);
        return reviewDto;
    }
}
