package com.restapi.bookrentalsystemrestapi.Service;

import com.restapi.bookrentalsystemrestapi.entities.Borrower;
import com.restapi.bookrentalsystemrestapi.exception.BookDetailsRequired;
import com.restapi.bookrentalsystemrestapi.entities.Book;
/*import org.springframework.data.jpa.bookrepository.Modifying;
import org.springframework.data.jpa.bookrepository.Query;*/
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private BookRepository1 repository1;
    private BookRepository bookrepository;
    private BorrowerRepository borrowerRepository;

    public BookService(BookRepository bookrepository, BorrowerRepository borrowerRepository,BookRepository1 bookRepository1) {
        this.bookrepository = bookrepository;
        this.borrowerRepository = borrowerRepository;
        this.repository1=bookRepository1;
    }

    public Book addBook(Book borrower)
    {
        List<Book> list=bookrepository.findAll();
        for (Book book1:list) {
            if (book1.equals(borrower))
            {
                throw new BookDetailsRequired("Duplicate borrower details");
            }
        }
        return bookrepository.save(borrower);
    }


  public Optional<List<Book>> getBookbytitle(String bookName)
  {
      Optional<List<Book>> book1=bookrepository.findByBookTitleName(bookName);

      if (book1.isPresent())
      {
          return book1;
      }
      else
      {
          //throw new BookDetailsRequired("No results matched");
          //return (Book) bookrepository.findAll();
          return  Optional.empty();
      }
  }
  public int deleteByAuthorName(String booktitle)
  {

        // Optional<List<Book>> borrower=bookrepository.findByBookAuthorName(booktitle);
        return bookrepository.deleteByBookAuthorName(booktitle);
         /* if (borrower.isPresent())
          {
              String string=bookrepository.deleteByBookAuthorName(booktitle);
              return Optional.of((List<Book>) borrower.get());
          }
          else
              //throw new BookDetailsRequired("No record found with the name");
             return borrower.empty();*/
  }

    public Optional<List<Book>> getBookbyAuthorname(String authorname) {
        Optional<List<Book>> authorOptional=bookrepository.findByBookAuthorName(authorname);
       /* if (authorOptional.isPresent())
        {
            return authorOptional.get();
        }*/
       Book book;
       if (authorOptional.isPresent())
       {
           return authorOptional;
       }
        else
            return authorOptional.empty();
    }

    public List<Book> getAllBooks() {
        return bookrepository.findAll();
    }
   public Borrower rentBook(Borrower borrower)
   {
       borrowerRepository.save(borrower);
       bookrepository.findByBookIsbn(borrower.getBookIsbn());
      return borrower;
   }
   public Borrower returnBook(Borrower borrower)
   {
      int  optionalInteger =repository1.findByBookIsbn(borrower.getBookIsbn());
      repository1.deleteByBookIsbn(borrower.getBookIsbn());
     /* List<Borrower> list=repository1.findAllByBookIsbn(borrower.getBookIsbn());
      if (list.contains(borrower.getBookIsbn()))
      {
          repository1.deleteByBookIsbn(borrower.getBookIsbn());
          return borrower;
      }
       else
           throw new BookDetailsRequired("hdjja");*/
       return borrower;
   }
   public Optional<List<Borrower>> getAllBorrowerDeatils()
   {
       return Optional.ofNullable(borrowerRepository.findAll());
   }
}
