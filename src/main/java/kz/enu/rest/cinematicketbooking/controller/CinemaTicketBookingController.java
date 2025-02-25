package kz.enu.rest.cinematicketbooking.controller;

import kz.enu.rest.cinematicketbooking.model.Cinema;
import kz.enu.rest.cinematicketbooking.model.Movie;
import kz.enu.rest.cinematicketbooking.model.Viewer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CinemaTicketBookingController {

    private final List<Movie> movies = new ArrayList<>();
    private final List<Viewer> viewers = new ArrayList<>();
    private final List<Cinema> cinemas = new ArrayList<>();

    // Получить список фильмов
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movies;
    }

    // Добавить фильм
    @PostMapping("/movies")
    public String addMovie(@RequestBody Movie movie) {
        movies.add(movie);
        return "Фильм добавлен: " + movie.getTitle();
    }

    // Получить список зрителей
    @GetMapping("/viewers")
    public List<Viewer> getViewers() {
        return viewers;
    }

    // Добавить зрителя
    @PostMapping("/viewers")
    public String addViewer(@RequestBody Viewer viewer) {
        viewers.add(viewer);
        return "Зритель добавлен: " + viewer.getName();
    }

    // Получить список кинотеатров
    @GetMapping("/cinemas")
    public List<Cinema> getCinemas() {
        return cinemas;
    }

    // Добавить кинотеатр
    @PostMapping("/cinemas")
    public String addCinema(@RequestBody Cinema cinema) {
        cinemas.add(cinema);
        return "Кинотеатр добавлен: " + cinema.getName();
    }

    // Забронировать билет
    @PostMapping("/book")
    public String bookTicket(@RequestParam Long viewerId, @RequestParam Long movieId, @RequestParam Long cinemaId) {
        return "Билет забронирован: Зритель " + viewerId + ", Фильм " + movieId + ", Кинотеатр " + cinemaId;
    }
}
