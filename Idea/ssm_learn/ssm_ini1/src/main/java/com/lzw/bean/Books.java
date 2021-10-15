package com.lzw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private Integer bookid;

    private String bookname;

    private Integer bookcounts;

    private String detail;

    public Integer getBookid(){
        return bookid;
    }

    public void setBookid(Integer bookid){
        this.bookid = bookid;
    }

    public String getBookname(){
        return bookname;
    }

    public void setBookname(String bookname){
        this.bookname = bookname;
    }

    public Integer getBookcounts(){
        return bookcounts;
    }

    public void setBookcounts(Integer bookcounts){
        this.bookcounts = bookcounts;
    }

    public String getDetail(){
        return detail;
    }

    public void setDetail(String detail){
        this.detail = detail;
    }

    @Override
    public String toString(){
        return "Books{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", bookcounts=" + bookcounts +
                ", detail='" + detail + '\'' +
                '}';
    }
}