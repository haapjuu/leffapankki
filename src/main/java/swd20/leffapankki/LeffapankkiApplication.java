package swd20.leffapankki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import swd20.leffapankki.domain.Movie;
import swd20.leffapankki.domain.MovieRepo;
import swd20.leffapankki.domain.User;
import swd20.leffapankki.domain.UserRepo;
import swd20.leffapankki.domain.Category;
import swd20.leffapankki.domain.CategoryRepo;

@SpringBootApplication
public class LeffapankkiApplication {

	private static final Logger log = LoggerFactory.getLogger(LeffapankkiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LeffapankkiApplication.class, args);
	}

	@Bean
	public CommandLineRunner MoviesaveDemo(MovieRepo MovieRepo, CategoryRepo categoryRepo, UserRepo userRepo) { 
		return (args) -> {
			
			log.info("create categories");
			
			categoryRepo.save(new Category("Scifi"));
			categoryRepo.save(new Category("Drama"));
			categoryRepo.save(new Category("Action"));
			categoryRepo.save(new Category("Comedy"));
			categoryRepo.save(new Category("Documentary"));
			categoryRepo.save(new Category("Horror"));
			
			log.info("save movies with categories");
				
			MovieRepo.save(new Movie("Interstellar", 8, 2014, categoryRepo.findByName("Scifi").get(0)));
			MovieRepo.save(new Movie("Inception", 7, 2010, categoryRepo.findByName("Scifi").get(0)));
			MovieRepo.save(new Movie("Pulp Fiction", 8, 1994, categoryRepo.findByName("Drama").get(0)));
			MovieRepo.save(new Movie("Titanic", 8, 1997, categoryRepo.findByName("Drama").get(0)));
			MovieRepo.save(new Movie("Avengers: Endgame", 8, 2019, categoryRepo.findByName("Action").get(0)));
			MovieRepo.save(new Movie("John Wick", 7, 2014, categoryRepo.findByName("Action").get(0)));
			MovieRepo.save(new Movie("Superbad", 7, 2007, categoryRepo.findByName("Comedy").get(0)));
			MovieRepo.save(new Movie("Bruce Almighty", 6, 2003, categoryRepo.findByName("Comedy").get(0)));
			MovieRepo.save(new Movie("Inside Job", 8, 2010, categoryRepo.findByName("Documentary").get(0)));
			MovieRepo.save(new Movie("Citizenfour", 8, 2014, categoryRepo.findByName("Documentary").get(0)));
			MovieRepo.save(new Movie("Relic", 6, 2020, categoryRepo.findByName("Horror").get(0)));
			MovieRepo.save(new Movie("Us", 7, 2019, categoryRepo.findByName("Horror").get(0)));
		
			
			log.info("fetch all Movies");
			
			for(Movie Movie : MovieRepo.findAll()) {
				log.info(Movie.toString());
			}
			
			User user1 = new User("user", "$2a$04$G5PqiG7vl0t1aYCVkT7pt.yPFB1uBeYJ53QWlnVU8O3aFXNH09/Te", "user@Moviestore.com","USER");
			User user2 = new User("admin", "$2a$04$O.yAQuuezI.z2Zbd3U8XGeQ2YDb8N2lSnJzbEdhzdZE0ODnJ1jf/G", "admin@Moviestore.com", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
		};
	}
}
