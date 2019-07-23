package com.restapi.bookrentalsystemrestapi.Service;

import com.restapi.bookrentalsystemrestapi.entities.Book;
import com.restapi.bookrentalsystemrestapi.entities.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {

}
