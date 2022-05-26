package com.latihanDaerah.latihanDaerah.services;

import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.BookRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.PinjamBukuRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.UserRequest;
import com.latihanDaerah.latihanDaerah.dto.response.Response;

public interface BookService {
    // Crud User
    public Response createUser(UserRequest userRequest) throws NullException;

    public Response getUsers();

    public Response updateUser(Integer id, UserRequest userRequest) throws Exception;

    public Response getUserById(Integer id) throws Exception;

    public Response deleteUser(Integer id) throws Exception;

    // Crud Book
    public Response createBook(List<BookRequest> bookRequest) throws Exception;

    public Response getBooks();

    public Response UpdateBook(Integer id, BookRequest bookRequest) throws Exception;

    public Response getBookById(Integer id) throws Exception;

    public Response deleteBook(Integer id) throws Exception;

    //Crud Peminjaman buku
    public Response peminjamanBuku(PinjamBukuRequest pinjamBukuRequest) throws Exception;
    public Response getDaftarPinjam();
    public Response getPinjamById(Integer id) throws Exception;
    public Response deletePinjam(Integer id) throws Exception;
}
