package ankit.learn.spring5webapp.bootstrap;

import ankit.learn.spring5webapp.model.Author;
import ankit.learn.spring5webapp.model.Book;
import ankit.learn.spring5webapp.model.Publisher;
import ankit.learn.spring5webapp.repositories.AuthorRepository;
import ankit.learn.spring5webapp.repositories.BookRepository;
import ankit.learn.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by ankitpranav on 10/7/18.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author ankit = new Author("ANKIT","PRANAV");
        Publisher p1 = new Publisher("abhi", "balaghat");
        publisherRepository.save(p1);
        Book b1 = new Book("Wheights", 1234l,p1);
        ankit.getBooks().add(b1);
        b1.getAuthors().add(ankit);

        authorRepository.save(ankit);
        bookRepository.save(b1);

        Author himanshu = new Author("HIMANSHU","SHANDILYA");
        Publisher p2 = new Publisher("himmu", "patna");
        publisherRepository.save(p2);
        Book b2 = new Book("MEIN KAMPF", 12345l, p2);
        himanshu.getBooks().add(b2);
        b2.getAuthors().add(himanshu);

        authorRepository.save(himanshu);
        bookRepository.save(b2);

    }
}
