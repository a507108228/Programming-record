package com.atguigu.mpdemo1010.mapper;

import com.atguigu.mpdemo1010.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectiveByDeleted(@Param("deleted") Integer deleted);
}

