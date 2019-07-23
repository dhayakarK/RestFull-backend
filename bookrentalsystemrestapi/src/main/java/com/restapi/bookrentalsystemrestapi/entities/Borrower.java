package com.restapi.bookrentalsystemrestapi.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Python")
public class Borrower {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(message = "minimum 2 chars required")
    @Column(name = "first_Name")
    private String firstName;
    @Size(message = "minimum 2 chars required")
    @Column(name = "last_Name")
    private String lastName;

    @Email(message = "should be in format",regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Column(name = "email")
    private String email;
    @Column(name = "no_Of_days")
    private int noOfdays;
    @Column(name = "book_Author_Name")
    private String bookAuthorName;
    @Column(name = "book_Title_Name")
    private String bookTitleName;
    @Column(name = "book_isbn")
    private long bookIsbn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(long bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    /* @ManyToOne
        @JoinColumn
       private Book book;*/
    public Borrower() {
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;*/


    public String  getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoOfdays() {
        return noOfdays;
    }

    public void setNoOfdays(int noOfdays) {
        this.noOfdays = noOfdays;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookTitleName() {
        return bookTitleName;
    }

    public void setBookTitleName(String bookTitleName) {
        this.bookTitleName = bookTitleName;
    }
}
