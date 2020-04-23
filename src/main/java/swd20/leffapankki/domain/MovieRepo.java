package swd20.leffapankki.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface MovieRepo extends CrudRepository<Movie, Long> {

	List <Movie> findById(@Param("id") long id);
		
}