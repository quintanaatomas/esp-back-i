package com.dh.movie.domain.data;

import com.dh.movie.domain.model.Movie;
import com.dh.movie.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(new Movie(null, "Smile ", "Terror", "https://www.youtube.com/watch?v=yhKiQGJop_8"));
        movieRepository.save(new Movie(null, "El Hombre del Norte", "Aventura", "https://www.youtube.com/watch?v=7HZ4tBQEiB0"));
        movieRepository.save(new Movie(null, "Black Adam", "Accion", "https://www.youtube.com/watch?v=kOFTZWyaOgc"));
        movieRepository.save(new Movie(null, "The Fallout", "Ficcion", "https://www.youtube.com/watch?v=hCBWOfCgRh4"));
    }
}
