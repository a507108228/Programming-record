package com.lzw.bean;

import lombok.Data;


@Data
public class Topic{

    private int id;
    private String tagName;
    private String name;
    private String url;
    private int weight;
    private String note;
}
