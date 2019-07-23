package com.restapi.bookrentalsystemrestapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Java")

@JsonIgnoreProperties(allowGetters = true,allowSetters = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    @Size(min = 2,message = "required atleast two chars")
    @Column(name = "book_title_name")
    private String bookTitleName;
    @NotBlank
    @Column(name = "book_author_name")
    @Size(min = 2,message = "required atleast two charcters")
    private String bookAuthorName;
  //  @NotNull
    @Column(name = "book_isbn")
   // @Size(min = 2,message = "should be 13 digits String")
    private long bookIsbn;
    @Column(name = "book_count")
    private int bookCount;
    @Column(name = "is_academic")
    private String isAcademic;

    public Book() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitleName() {
        return bookTitleName;
    }

    public void setBookTitleName(String bookTitleName) {
        this.bookTitleName = bookTitleName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public long getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getIsAcademic() {
        return this.isAcademic;
    }

    public void setIsAcademic(String isAcademic) {
        this.isAcademic = isAcademic;
    }

    @Override
    public boolean equals(Object obj) {
        Book book=(Book)obj;
        boolean book_title= Objects.equals(this.getBookTitleName(), book.getBookTitleName());
        boolean book_author= Objects.equals(this.getBookAuthorName(), book.getBookAuthorName());
        return (book_title&&book_author);
    }


}
