package com.lzw.service;

import com.lzw.bean.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a5071
 * @since 2021/11/18 19:00
 * description
 */
@Service
public interface TestService{

    List<Tag> getAllTags();
}
