package com.latihanDaerah.latihanDaerah.validation;

import java.util.List;

import com.latihanDaerah.latihanDaerah.Exception.BadRequestException;
import com.latihanDaerah.latihanDaerah.Exception.NullException;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.BookRequest;
import com.latihanDaerah.latihanDaerah.dto.request.BooksRequest.UserRequest;
import com.latihanDaerah.latihanDaerah.model.BooksModel.Book;
import com.latihanDaerah.latihanDaerah.model.BooksModel.PinjamBuku;
import com.latihanDaerah.latihanDaerah.model.BooksModel.User;

import org.springframework.stereotype.Service;

@Service
public class BookValidation {

    public void createUserValidation(UserRequest userRequest) throws NullException {
        if (userRequest.getFullName() == null || userRequest.getPassword() == null
                || userRequest.getUsername() == null) {
            throw new NullException("Attribute tiidak boleh kosong harus di isi");
        }
    }

    public void updateUserValidation(UserRequest userRequest, User user) throws Exception {
        if (user == null) {
            throw new NullException("Data tidak tersedia");
        }
        if (user.getIsDeleted() == true) {
            throw new NullException("Data sudah di hapus tidak bisa di update");
        } else {
            userRequest.setIsDeleted(false);
        }
        if (userRequest.getUserId() == null) {
            userRequest.setUserId(user.getUserId());
        } else {
            throw new BadRequestException("Tidak bisa mengganti code provinsi");
        }
    }

    public void getUserByIdValidation(User user) throws NullException {
        if (user == null) {
            throw new NullException("Data Tidak ada");
        }
    }

    public void deleteUserValidation(User user) throws Exception {
        if (user == null) {
            throw new NullException("Data tidak ada");
        }
    }

    // validasi Book
    public void createBookValidation(List<BookRequest> book, List<Book> bookDb) throws Exception {
        for (int i = 0; i < book.size(); i++) {
            if (book.get(i).getJudul() == null || book.get(i).getPenulis() == null) {
                throw new NullException("Attribute tiidak boleh kosong harus di isi");
            }
            
        }
        for(int i = 0 ; i < bookDb.size(); i++){
            if (bookDb.get(i) != null) {
                throw new BadRequestException("Nama Buku sudah ada");
            }
        }

    }

    public void updateBookValidation(BookRequest bookRequest, Book book) throws Exception {
        if (book == null) {
            throw new NullException("Data tidak tersedia");
        }
        if (book.getIsDeleted() == true) {
            throw new NullException("Data sudah di hapus tidak bisa di update");
        } else {
            bookRequest.setIsDeleted(false);
        }
        if (bookRequest.getBookId() == null) {
            bookRequest.setBookId(book.getBookId());
        } else {
            throw new BadRequestException("Tidak bisa mengganti code provinsi");
        }
    }

    public void getBookByIdValidation(Book book) throws NullException {
        if (book == null) {
            throw new NullException("Data Tidak ada");
        }
    }
    public void deleteBookValidation(Book book) throws Exception {
        if (book == null) {
            throw new NullException("Data tidak ada");
        }
    }

    // validasi peminjaman buku
    public void pinjamanBukuValidation(User user, Book book) throws Exception{
        if(user == null){
            throw new BadRequestException("user tidak di temukan");
        }
        if(book == null){
            throw new BadRequestException("Buku tidak ada");
        }
        if(user.getIsDeleted() == true){
            throw new BadRequestException("User sudah di hapus, anda harus membuat akun terlebih dahulu");
        }
        if(book.getIsDeleted() == true){
            throw new BadRequestException("Buku sudah tidak ada, tidak bisa pinjam buku" + book.getJudul());
        }
    }
    public void getPinjamByIdValidation(PinjamBuku pinjam) throws NullException {
        if (pinjam == null) {
            throw new NullException("Data Tidak ada");
        }
    }

    public void deletePinjamkValidation(PinjamBuku pinjam) throws Exception {
        if (pinjam == null) {
            throw new NullException("Data tidak ada");
        }
    }
}
