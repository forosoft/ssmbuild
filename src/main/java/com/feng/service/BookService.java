package com.feng.service;

import com.feng.pojo.Book;

import java.util.List;

public interface BookService {

    //查询一本书
    Book queryBookById(int bookId);

    //查询全部书
    List<Book> queryAllBook();

    //增加一本书
    int addBook(Book book);

    //删除一本书
    int delBook(int bookId);

    //更新一本书
    int updateBook(Book book);

    //根据书名查询书籍
    List<Book> queryBookByName(String bookName);
}
