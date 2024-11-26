package kr.ac.kopo.moviereview.repository;

import kr.ac.kopo.moviereview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
