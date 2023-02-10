package dev.marcin.movieapi.movie;

import dev.marcin.movieapi.review.ReviewDto;
import dev.marcin.movieapi.review.ReviewMapper;

import java.util.stream.Collectors;

public class MovieMapper {
    public static MovieDto map(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setBackdrops(movie.getBackdrops());
        movieDto.setGenres(movie.getGenres());
        movieDto.setImdbId(movie.getImdbId());
        movieDto.setPoster(movie.getPoster());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setReviewIds(movie.getReviewIds().stream().map(e->{
            ReviewDto reviewDto = ReviewMapper.map(e);
            reviewDto.setMovieImdb(movie.getImdbId());
            return reviewDto;
        }).collect(Collectors.toList()));
        movieDto.setTrailerLink(movie.getTrailerLink());
        movieDto.setTitle(movie.getTitle());
        return movieDto;
    }
}
