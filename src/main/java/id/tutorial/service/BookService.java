package id.tutorial.service;

import id.tutorial.model.dto.BookDto;
import id.tutorial.model.dto.ResponseData;

public interface BookService {
  ResponseData<Object> createBook(BookDto dto);

  ResponseData<Object> getAllBook(Boolean status);

  ResponseData<Object> getById(Integer id);

  ResponseData<Object> updateBook(Integer id, BookDto bookDto);

  ResponseData<Object> deleteBook(Integer id, Integer status);
}
