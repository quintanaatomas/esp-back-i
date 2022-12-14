package com.dh.catalog.api.controller;

import com.dh.catalog.api.client.MovieServiceClient;
import com.dh.catalog.api.queue.MovieSender;
import com.dh.catalog.domain.models.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	private final MovieServiceClient movieServiceClient;

	private final MovieSender movieSender;

	public CatalogController(MovieServiceClient movieServiceClient, MovieSender movieSender) {
		this.movieServiceClient = movieServiceClient;
		this.movieSender = movieSender;
	}

	@GetMapping("/{genre}")
	ResponseEntity<List<MovieServiceClient.MovieDto>> getGenre(@PathVariable String genre) {
		return ResponseEntity.ok(movieServiceClient.getMovieByGenre(genre));
	}

	@GetMapping("/withErrors/{genre}")
	ResponseEntity<List<MovieServiceClient.MovieDto>> getGenre(@PathVariable String genre, @RequestParam("throwError") Boolean throwError) {
		return movieServiceClient.getMovieByGenreWithThrowError(genre, throwError);
	}

	@PostMapping("/save")
	public void saveMovie(@RequestBody Movie movie) { movieSender.send(movie);}

}
