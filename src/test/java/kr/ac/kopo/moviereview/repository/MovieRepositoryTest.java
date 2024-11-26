package kr.ac.kopo.moviereview.repository;

import kr.ac.kopo.moviereview.entity.Movie;
import kr.ac.kopo.moviereview.entity.MovieImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository imageRepository;

    @Test
    public void insertMovies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Movie movie = Movie.builder()
                    .title("Movie Test " + i)
                    .build();

            movieRepository.save(movie);

            int imgCount = (int) (Math.random() * 5) + 1;

            for(int j = 0; j < imgCount; j++){
                MovieImage movieImage = MovieImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .movie(movie)
                        .imgName("test"+j+".jpg")
                        .build();

                imageRepository.save(movieImage);
            }
        });
    }
}
