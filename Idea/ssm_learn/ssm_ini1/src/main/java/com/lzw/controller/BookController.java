package com.lzw.controller;

import com.lzw.bean.Books;
import com.lzw.service.BooksService;
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
    BooksService bookService;


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

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBookName(String queryBookByName, Model model){
        Books books = bookService.queryBookByName(queryBookByName);
        System.out.println(books);
        List<Books> list = new ArrayList<>();
        list.add(books);

        if ( books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error","查询失败");
        }

        model.addAttribute("list",list);
        return "allBook";
    }


//    /book/toAddBook">新增
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.insert(books);
        return "redirect:/book/allBook";
    }


//    /book/toUpdateBook?id=${book.getBookid()}">更改
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(Model model, int id){
        Books books = bookService.selectByPrimaryKey(id);
        System.out.println(books);
        model.addAttribute("book",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updatePaper(Model model, Books book){
        System.out.println(book);
        bookService.updateByPrimaryKeySelective(book);
        Books books = bookService.selectByPrimaryKey(book.getBookid());
        model.addAttribute("book",books);
        return "redirect:/book/allBook";
    }

//    /book/del/${book.getBookid()}">删除

    @RequestMapping("/del/{bookid}")
    public String deleteBook(@PathVariable("bookid") int id){
        bookService.deleteByPrimaryKey(id);
        return "redirect:/book/allBook";
    }
}
