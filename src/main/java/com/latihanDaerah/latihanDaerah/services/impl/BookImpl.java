package com.latihanDaerah.latihanDaerah.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.constant.DaerahConstant;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.BookRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.PinjamBukuRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.UserRequest;
import com.latihanDaerah.latihanDaerah.dto.response.Response;
import com.latihanDaerah.latihanDaerah.dto.response.BooksResponse.BookResponse;
import com.latihanDaerah.latihanDaerah.dto.response.BooksResponse.PinjamBukuResponse;
import com.latihanDaerah.latihanDaerah.dto.response.BooksResponse.UserResponse;
import com.latihanDaerah.latihanDaerah.model.BooksModel.Book;
import com.latihanDaerah.latihanDaerah.model.BooksModel.PinjamBuku;
import com.latihanDaerah.latihanDaerah.model.BooksModel.User;
import com.latihanDaerah.latihanDaerah.repository.BookRepo.BookRepo;
import com.latihanDaerah.latihanDaerah.repository.BookRepo.PinjamBukuRepo;
import com.latihanDaerah.latihanDaerah.repository.BookRepo.UserRepo;
import com.latihanDaerah.latihanDaerah.services.BookService;
import com.latihanDaerah.latihanDaerah.validation.BookValidation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImpl implements BookService {
    private Response response;

    @Autowired
    private DaerahConstant constantVar;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookValidation bookValidation;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PinjamBukuRepo pinjamBukuRepo;

    @Override
    public Response createUser(UserRequest userRequest) throws NullException{
        userRequest.setIsDeleted(false);
        bookValidation.createUserValidation(userRequest);
        User user = mapper.map(userRequest, User.class);
        userRepo.save(user);
        UserResponse userResponse = mapper.map(user, UserResponse.class);
        String msg = userResponse.getUsername() +  " Created";
        response = new Response(constantVar.getSTATUS_CREATED(), msg, userResponse);
        return response;
    }

    @Override
    public Response getUsers() {
        List<User> user =  userRepo.findAll();
        List<UserResponse> res = new ArrayList<>();
        for(int i = 0 ; i < user.size() ; i++){
            res.add(mapper.map(user.get(i), UserResponse.class));
        }
        response = new Response(constantVar.getSTATUS_OK(), "Get Data", res);
        return response;
    }

    @Override
    public Response updateUser(Integer id, UserRequest userRequest) throws Exception {
        User user = userRepo.findByUserId(id);
        bookValidation.updateUserValidation(userRequest, user);
        User userUpdate = mapper.map(userRequest, User.class);
        userRepo.save(userUpdate);
        UserResponse res = mapper.map(userUpdate, UserResponse.class);
        response = new Response(constantVar.getSTATUS_OK(), "Updated", res);
        return response;
    }

    @Override
    public Response getUserById(Integer id) throws Exception {
        User user = userRepo.findByUserId(id);
        bookValidation.getUserByIdValidation(user);
        UserResponse res = mapper.map(user, UserResponse.class);
        response = new Response(constantVar.getSTATUS_OK(), "Get Data", res);
        return response;
    }

    @Override
    public Response deleteUser(Integer id) throws Exception {
        User user = userRepo.findByUserId(id);
        bookValidation.deleteUserValidation(user);
        user.setIsDeleted(true);
        String msg = "Data User: " + user.getFullName() + " telah di hapus";
        response = new Response(constantVar.getSTATUS_OK(), msg, null);
        return response;
    }

    // Method Book

	@Override
	public Response createBook(List<BookRequest> bookRequest) throws Exception {
		List<Book> bookDb = new ArrayList<>();
        for(int i = 0 ; i < bookRequest.size() ; i++){
            bookRequest.get(i).setIsDeleted(false);
            bookDb.add(bookRepo.findByJudul(bookRequest.get(i).getJudul())); 
            
        }

        bookValidation.createBookValidation(bookRequest, bookDb);
        List<Book> book = new ArrayList<>();
        List<BookResponse> res = new ArrayList<>();
        for(int j = 0 ; j < bookRequest.size(); j++){
            book.add(mapper.map(bookRequest.get(j), Book.class));
           
        }
        bookRepo.saveAll(book);
        for(int k = 0 ; k < book.size(); k++){
            res.add(mapper.map(book.get(k), BookResponse.class));
        }
        response =  new Response(constantVar.getSTATUS_OK(), "Success Create", res);
		return response;
	}

    @Override
    public Response getBooks() {
        List<Book> books = bookRepo.findAll();
        List<BookResponse> res = new ArrayList<>();
        for(int i = 0 ; i < books.size(); i++){
            res.add(mapper.map(books.get(i), BookResponse.class));
        }

        response = new Response(constantVar.getSTATUS_OK(), "Data di dapatkan", res);
        return response;
    }

    @Override
    public Response UpdateBook(Integer id, BookRequest bookRequest) throws Exception {
        Book book = bookRepo.findByBookId(id);
        bookValidation.updateBookValidation(bookRequest, book);
        Book bookUpdate = mapper.map(bookRequest, Book.class);
        bookRepo.save(bookUpdate);
        BookResponse res = mapper.map(bookUpdate, BookResponse.class);
        response = new Response(constantVar.getSTATUS_OK(), "Updated", res);
        return response;
    }

    @Override
    public Response getBookById(Integer id) throws Exception {
        Book book = bookRepo.findByBookId(id);
        bookValidation.getBookByIdValidation(book);
        BookResponse res = mapper.map(book, BookResponse.class);
        response = new Response(constantVar.getSTATUS_OK(), "Success", res);
        return response;
    }

    @Override
    public Response deleteBook(Integer id) throws Exception {
        Book book = bookRepo.findByBookId(id);
        bookValidation.deleteBookValidation(book);
        book.setIsDeleted(true);
        bookRepo.save(book);
        String msg = "Data Buku: " + book.getJudul() + " telah di hapus";
        response = new Response(constantVar.getSTATUS_OK(), msg, null);
        return response;
    }

    // Peminjaman Buku
    @Override
    public Response peminjamanBuku(PinjamBukuRequest pinjamBukuRequest) throws Exception {
        User user = userRepo.findByUserId(pinjamBukuRequest.getUserId());
        Book book = bookRepo.findByBookId(pinjamBukuRequest.getBookId());
        bookValidation.pinjamanBukuValidation(user, book);
        PinjamBuku pinjam = mapper.map(pinjamBukuRequest, PinjamBuku.class);
        pinjam.setUser(user);
        pinjam.setBook(book);
        pinjam.setNamaPeminjam(user.getFullName());
        pinjamBukuRepo.save(pinjam);

        PinjamBukuResponse res = mapper.map(pinjam, PinjamBukuResponse.class);
        response = new Response(constantVar.getSTATUS_CREATED(), "Jadwal Peminjaman Berhasil", res);
        return response;
    }

    @Override
    public Response getDaftarPinjam() {
       List<PinjamBuku> pinjam = pinjamBukuRepo.findAll();
       List<PinjamBukuResponse> res = new ArrayList<>();

       for(int i = 0 ; i< pinjam.size();i++){
           res.add(mapper.map(pinjam.get(i), PinjamBukuResponse.class));
       }
       response = new Response(constantVar.getSTATUS_OK(), "Success", res);
        return response;
    }

    @Override
    public Response getPinjamById(Integer id) throws Exception {
        PinjamBuku pinjam = pinjamBukuRepo.findByIdPinjam(id);
        bookValidation.getPinjamByIdValidation(pinjam);
        PinjamBukuResponse res = mapper.map(pinjam, PinjamBukuResponse.class);
        response = new Response(constantVar.getSTATUS_OK(), "Success", res);
        return response;
    }

    @Override
    public Response deletePinjam(Integer id) throws Exception {
        PinjamBuku pinjam = pinjamBukuRepo.findByIdPinjam(id);
        bookValidation.deletePinjamkValidation(pinjam);
        pinjamBukuRepo.delete(pinjam);
        String msg = "Data peminjaman telah di hapus atas nama: " + pinjam.getNamaPeminjam() + " dengan buku: " + pinjam.getBook().getJudul();
        response = new Response(constantVar.getSTATUS_OK(), msg, null);
        return response;
    }
}
