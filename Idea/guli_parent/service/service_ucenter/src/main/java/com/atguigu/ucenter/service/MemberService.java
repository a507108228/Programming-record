package com.atguigu.ucenter.service;

import com.atguigu.ucenter.entity.Member;
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

    String login(Member member);
}
