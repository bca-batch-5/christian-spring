package id.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.tutorial.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByIsDeleted(Boolean status);
}
