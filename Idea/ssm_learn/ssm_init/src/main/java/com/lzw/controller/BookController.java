package com.lzw.controller;

import com.lzw.bean.Books;
import com.lzw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: a5071
 * @date: 2021/8/22 15:02
 * @description:
 */
@Controller
@RequestMapping("/book")
public class BookController{

    @Autowired
    BookService bookService;


    /**
     * @author: a5071
     * @description: 查询全部书籍
     */
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    /**
     * @author: a5071
     * @description: 添加书籍
     */
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    /**
     * @author: a5071
     * @description: 删除
     */
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    /**
     * @author: a5071
     * @description: 更改
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book){
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);

        if (books == null) {
            list = bookService.queryAllBook();
            model.addAttribute("error","查询失败");
        }
        model.addAttribute("list",list);
        return "allBook";
    }

}
