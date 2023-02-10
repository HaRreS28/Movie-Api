package dev.marcin.movieapi.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<MovieDto> allMovies(){
        return movieRepository.findAll().stream().map(MovieMapper::map).collect(Collectors.toList());
    }

    public Optional<MovieDto> singleMovie(String id){
        return movieRepository.findByImdbId(id).map(MovieMapper::map);
    }
}
