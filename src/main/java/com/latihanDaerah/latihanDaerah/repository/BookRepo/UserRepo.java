package com.latihanDaerah.latihanDaerah.repository.BookRepo;

import com.latihanDaerah.latihanDaerah.model.BooksModel.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUserId(Integer id);
}
