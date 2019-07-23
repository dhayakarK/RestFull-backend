package com.restapi.bookrentalsystemrestapi.Service;

import com.restapi.bookrentalsystemrestapi.entities.Book;
import com.restapi.bookrentalsystemrestapi.entities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository1 extends JpaRepository<Book,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Java set book_count=book_count+1 where book_isbn=:book_isbn",nativeQuery = true)
    int findByBookIsbn(long book_isbn );
    @Transactional
    @Modifying
    @Query(value = "delete from Python where book_isbn=:book_isbn",nativeQuery = true)
    int deleteByBookIsbn(long book_isbn);


    List<Borrower> findAllByBookIsbn(long book_isbn);
}
