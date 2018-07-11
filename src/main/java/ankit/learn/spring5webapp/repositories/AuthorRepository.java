package ankit.learn.spring5webapp.repositories;

import ankit.learn.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ankitpranav on 10/7/18.
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
