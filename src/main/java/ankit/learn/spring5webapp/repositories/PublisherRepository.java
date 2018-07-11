package ankit.learn.spring5webapp.repositories;

import ankit.learn.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ankitpranav on 10/7/18.
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
