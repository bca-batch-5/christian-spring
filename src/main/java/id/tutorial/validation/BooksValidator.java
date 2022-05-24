package id.tutorial.validation;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import id.tutorial.model.Book;
import id.tutorial.model.dto.BookDto;
import id.tutorial.model.dto.ResponseData;
import id.tutorial.repository.BookRepository;

@Service
public class BooksValidator {
    ResponseData<Object> responseData;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public ResponseData<Object> getBookWithId(Optional<Book> bookOpt) {
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();

            return responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success", book);
        } else {
            return responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "not_found", null);
        }

    }

    public ResponseData<Object> updateBookValidation(Optional<Book> bookOpt, BookDto bookDTO) {
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            Book result = mapper.map(bookDTO, Book.class);
            result.setId(book.getId());
            result.setIsDeleted(book.getIsDeleted());
            return responseData = new ResponseData<Object>(HttpStatus.OK.value(), "success",
                    bookRepository.save(result));
        } else {
            return responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "not_found", null);
        }
    }

    public ResponseData<Object> deleteBookValidation(Optional<Book> bookOpt) {
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.getIsDeleted() == false) {

                book.setIsDeleted(true);

                bookRepository.save(book);

                String message = book.getTitle() + " berhasil dihapus.";

                return responseData = new ResponseData<Object>(HttpStatus.OK.value(), message, null);
            }else{
                
                return responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Data telah di hapus sebelumnya", null);
            }
        } else {
            return responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "not_found", null);
        }
    }
}
