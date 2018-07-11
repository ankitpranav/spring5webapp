package ankit.learn.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ankitpranav on 5/7/18.
 */
@Entity
@Table(name = "Book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  private Long isBin;

  @OneToOne
  private Publisher publisher;

  @ManyToMany
  @JoinTable(name = "Author_Book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  public Book(String name, Long isBin, Publisher publisher) {
    this.name = name;
    this.isBin = isBin;
    this.publisher = publisher;
  }

  public Book() {
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getIsBin() {
    return isBin;
  }

  public void setIsBin(Long isBin) {
    this.isBin = isBin;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;

    Book book = (Book) o;

    return getId() != null ? getId().equals(book.getId()) : book.getId() == null;

  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", isBin=" + isBin +
            ", publisher='" + publisher + '\'' +
            ", authors=" + authors +
            '}';
  }
}
