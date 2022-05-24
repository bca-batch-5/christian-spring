package id.tutorial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tutorial.model.Book;
import id.tutorial.model.dto.BookDto;
import id.tutorial.model.dto.ResponseData;
import id.tutorial.repository.BookRepository;
import id.tutorial.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookService bookService;

  Map<String, Object> response = new HashMap<>();
  ResponseData<Object> responseData;

  @GetMapping
  public ResponseEntity<?> getAll(@RequestParam(value = "status", defaultValue = "") Boolean status) {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBook(status));
    } catch (Exception e) {
      // TODO: handle exception
      responseData = new ResponseData<Object>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
    }

    // List<Book> books = bookRepository.findAll();

    // responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success",
    // books);

    // response.put("status", HttpStatus.OK.value()); // ok
    // response.put("error", false);
    // response.put("data", books);
    // response.put("message", "success");
    // return ResponseEntity.status(HttpStatus.OK).body(responseData);
  }

  @PostMapping
  public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDto));
    } catch (Exception e) {
      // TODO: handle exception
      responseData = new ResponseData<Object>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
    }
    // Book book = new Book(bookDto.getJudul(), bookDto.getPenulis());
    // // save to db
    // bookRepository.save(book);

    // response.put("status", HttpStatus.OK.value()); // ok
    // response.put("error", false);
    // response.put("data", null);
    // response.put("message", "success");
    // return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    return ResponseEntity
        .status(bookService.getById(id).getStatus())
        .body(bookService.getById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody BookDto bookDto) {
    responseData = bookService.updateBook(id, bookDto);
    return ResponseEntity.status(responseData.getStatus())
        .body(responseData);
  } 

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable Integer id, Integer status) {
    responseData = bookService.deleteBook(id, status);
    return ResponseEntity.status(responseData.getStatus()).body(responseData);

  }

  @GetMapping("/active")
  public ResponseEntity<?> getActiveBooks(@RequestParam(value = "status") Boolean status) {
    List<Book> book = bookRepository.findByIsDeleted(status);

    responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "success", book);
    return ResponseEntity.ok(responseData);
  }
}
