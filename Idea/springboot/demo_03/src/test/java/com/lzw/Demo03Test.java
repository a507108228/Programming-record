package com.lzw;

import com.lzw.entity.TblBook;
import com.lzw.mapper.TblBookMapper;
import com.lzw.service.impl.TblBookServiceImpl;
import com.lzw.utils.R;
import com.lzw.utils.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author a5071
 * @since 2021/12/4 22:59
 * description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03Test{

    @Autowired
    private TblBookMapper bookMapper;

    @Autowired
    private TblBookServiceImpl bookServiceImpl;

    @Test
    public void test(){
        for (int i = 0; i < 20; i++) {
            String uuid = UUIDUtils.getLowerUUID(5);
            boolean save = bookServiceImpl.save(new TblBook(null, uuid, uuid, uuid));

            if (save){
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        }

    }
}
