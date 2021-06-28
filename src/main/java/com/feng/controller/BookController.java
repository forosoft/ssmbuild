package com.feng.controller;

import com.feng.pojo.Book;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {


    //controller 调用 service 层


    //在使用 @Autowired 进行自动装配时，将会按照需要注入的变量名称来寻找合适的 bean
    //或者用 @Qualifier("bookServiceImpl")
    @Autowired
    private BookService bookServiceImpl;

    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Book> books = bookServiceImpl.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }


    @RequestMapping("/toAddBook")
    public String toAddBook(Model model) {
        return "addBook";
    }


    @PostMapping("/addBook")
    public String addBook(Book book) {
        bookServiceImpl.addBook(book);
        return "redirect:/book/allBook"; //重定向 @RequestMapping("/allBook") 请求
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int bookId, Model model) {
        Book book = bookServiceImpl.queryBookById(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookServiceImpl.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id, Model model) {
        int result = bookServiceImpl.delBook(id);
        if (result > 0) {
            model.addAttribute("msg", "删除成功!");
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBookByName")
    public String deleteBook(String queryBookName, Model model) {
        List<Book> books = null;
        if (!StringUtils.isEmpty(queryBookName)) {
            books = bookServiceImpl.queryBookByName(queryBookName);
            if (StringUtils.isEmpty(books) || books.size() == 0) {
                model.addAttribute("error", "未查询相关书籍");
            }
        } else {
            books = bookServiceImpl.queryAllBook();
        }
        model.addAttribute("list", books);
        return "allBook";
    }
}
