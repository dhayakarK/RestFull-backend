package com.restapi.bookrentalsystemrestapi.Service;

import com.restapi.bookrentalsystemrestapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Optional<List<Book>> findByBookTitleName(String name);

    //Optional<Book> findByBookAuthorName(String authorname);

   Optional<List<Book>> findByBookAuthorName(String name);

  /* @Transactional
   @Modifying
   @Query(value = "delete from Java where book_author_name=:book_author_name");
   String deleteByBookAuthorName(String book_author_name);*/

  // Optional<Book> deleteById(int id);
    @Transactional
    int deleteByBookAuthorName(String book_author_name);
    @Transactional
    @Modifying
   @Query(value = "update Java set book_count=book_count-1 where book_isbn=:book_isbn",nativeQuery = true)
   int findByBookIsbn(long book_isbn);


}
