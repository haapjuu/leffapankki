package swd20.leffapankki;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.leffapankki.domain.User;
import swd20.leffapankki.domain.UserRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTests {

	@Autowired
	UserRepo userRepo;
	
	@Test
	public void createNewUser() {
		User testuser = new User("testuser", "$2a$04$inICAQ46l0Qo/uyZz8BJy.GnLm8otmv7FO5e9xrmYw3R2Mk.yKQbK", "testuser@bookstore.fi", "user");
		userRepo.save(testuser);
		assertThat(testuser.getId()).isNotNull();
	}
	
	@Test
	public void findByUserName() {
		User user = userRepo.findByUsername("admin");
		assertThat(user).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User deleteuser = new User("deleteuser", "$2a$04$AQdCzXayYxlNaiCUWMxyKenko2g1b3V8V.0lHcfr1t8U9BRFQIOha", "deleteuser@bookstore.fi", "user");
		userRepo.save(deleteuser);
		long id = deleteuser.getId();
		userRepo.delete(deleteuser);
		assertThat(userRepo.findById(id)).isEmpty();
	}
}
