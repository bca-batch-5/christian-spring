package id.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.status.Status;
import id.tutorial.model.Book;
import id.tutorial.model.dto.BookDto;
import id.tutorial.model.dto.ResponseData;
import id.tutorial.repository.BookRepository;
import id.tutorial.validation.BooksValidator;

@Service
@Transactional
public class BookServiceImpl implements BookService {
  private ResponseData<Object> responseData;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BooksValidator booksValidator;

  @Override
  public ResponseData<Object> createBook(BookDto dto) {
    // TODO Auto-generated method stub
    Book book = new Book(dto.getTitle(), dto.getAuthor());
    // save to db
    bookRepository.save(book);

    responseData = new ResponseData<>(HttpStatus.CREATED.value(), "success", book);

    return responseData;
  }

  @Override
  public ResponseData<Object> getAllBook(Boolean status) {
    // TODO Auto-generated method stub
    List<Book> books;
    if (status == null) {
      books = bookRepository.findAll();

      responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success", books);
      return responseData;
    } else {
      books = bookRepository.findByIsDeleted(status);

      responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", books);
      return responseData;
    }
  }

  @Override
  public ResponseData<Object> getById(Integer id) {
    Optional<Book> bookOpt = bookRepository.findById(id);
    responseData = booksValidator.getBookWithId(bookOpt);
    return responseData;
  }

  @Override
  public ResponseData<Object> updateBook(Integer id, BookDto bookDto) {
    Optional<Book> bookOpt = bookRepository.findById(id);
    return booksValidator.updateBookValidation(bookOpt, bookDto);
  }

  @Override
  public ResponseData<Object> deleteBook(Integer id, Integer status) {
    Optional<Book> bookOpt = bookRepository.findById(id);
    responseData = booksValidator.deleteBookValidation(bookOpt);
    status = responseData.getStatus();
    return responseData;

  }

}
