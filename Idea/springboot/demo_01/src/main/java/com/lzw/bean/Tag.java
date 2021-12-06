package com.lzw.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author a5071
 * @since 2021/12/1 21:36
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag{

        @TableId(value = "id", type = IdType.ID_WORKER_STR)
        private String id;

        private String name;

        private String url;

}
