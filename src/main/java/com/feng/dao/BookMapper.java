package com.feng.dao;

import com.feng.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {


    //查询一本书
    Book queryBookById(@Param("bookId") int bookId);

    //查询全部书
    List<Book> queryAllBook();

    //增加一本书
    int addBook(Book book);

    //删除一本书
    int delBook(@Param("bookId") int bookId);

    //更新一本书
    int updateBook(Book book);

    //根据书名查询书籍
    List<Book> queryBookByName(@Param("bookName") String bookName);

}
