package com.latihanDaerah.latihanDaerah.controller;

import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.BookRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.PinjamBukuRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.UserRequest;
import com.latihanDaerah.latihanDaerah.dto.response.Response;
import com.latihanDaerah.latihanDaerah.model.BooksModel.PinjamBuku;
import com.latihanDaerah.latihanDaerah.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class BookController {
    private Response response;

    @Autowired
    private BookService bookService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) throws NullException{
        response = bookService.createUser(userRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUsers(){
        response = bookService.getUsers();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) throws Exception{
        response = bookService.updateUser(id, userRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) throws Exception{
        response = bookService.getUserById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws Exception{
        response = bookService.deleteUser(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Book Controller
    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody List<BookRequest> bookRequest) throws Exception{
        response = bookService.createBook(bookRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/book")
    public ResponseEntity<?> getBooks() {
        response = bookService.getBooks();
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody BookRequest bookRequest) throws Exception{
        response = bookService.UpdateBook(id, bookRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) throws Exception {
        response = bookService.getBookById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) throws Exception{
        response = bookService.deleteBook(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // pinjam buku controller
    @PostMapping("/book/pinjam")
    public ResponseEntity<?> peminjaman(@RequestBody PinjamBukuRequest pinjamBukuRequest) throws Exception{
        response = bookService.peminjamanBuku(pinjamBukuRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/book/pinjam")
    public ResponseEntity<?> daftarPinjam() {
        response = bookService.getDaftarPinjam();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/book/pinjam/{id}")
    public ResponseEntity<?> getdaftarPinjamById(@PathVariable Integer id) throws Exception{
        response = bookService.getPinjamById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    @DeleteMapping("/book/pinjam/{id}")
    public ResponseEntity<?> deletePinjam(@PathVariable Integer id) throws Exception{
        response = bookService.deletePinjam(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
