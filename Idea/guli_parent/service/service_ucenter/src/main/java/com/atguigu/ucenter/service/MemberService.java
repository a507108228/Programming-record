package com.atguigu.ucenter.service;

import com.atguigu.ucenter.entity.Member;
import com.atguigu.ucenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author lzw
 * @since 2021-10-31
 */
public interface MemberService extends IService<Member> {

    //登录的方法
    String login(Member member);

    //注册的方法
    void register(RegisterVo registerVo);

    //根据openid判断
    Member getOpenIdMember(String openid);
}
