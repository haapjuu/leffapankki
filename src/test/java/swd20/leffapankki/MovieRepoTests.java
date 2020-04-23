package swd20.leffapankki;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.leffapankki.domain.CategoryRepo;
import swd20.leffapankki.domain.Category;
import swd20.leffapankki.domain.Movie;
import swd20.leffapankki.domain.MovieRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepoTests {

	@Autowired MovieRepo movieRepo;
	@Autowired CategoryRepo categoryRepo;
	
	@Test
	public void findById() {
		List<Movie> movies = movieRepo.findById(10);
		assertThat(movies).hasSize(1);
		assertThat(movies.get(0).getTitle()).isEqualTo("Titanic");
	}
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("test title 1", 2, 2019, new Category("comic"));
		movieRepo.save(movie);
		assertThat(movie.getId()).isNotNull();
	}
	
}