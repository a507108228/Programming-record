package com.lzw.service;

import com.lzw.bean.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 21:37
 * description
 */
@Service
public interface TagService{

    List<Tag> selectAll();
}
