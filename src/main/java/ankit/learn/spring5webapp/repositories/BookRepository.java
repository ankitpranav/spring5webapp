package ankit.learn.spring5webapp.repositories;

import ankit.learn.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ankitpranav on 10/7/18.
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
