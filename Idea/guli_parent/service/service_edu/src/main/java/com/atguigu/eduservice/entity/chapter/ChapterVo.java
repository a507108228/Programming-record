package com.atguigu.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a5071
 * @since 2021/10/16 17:27
 * description:
 */
@Data
public class ChapterVo{

    private String id;

    private String title;

    // 表示小节
    private List<VideoVo> children = new ArrayList<>();


}
