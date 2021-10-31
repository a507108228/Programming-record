package com.atguigu.ucenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.ucenter.entity.Member;
import com.atguigu.ucenter.mapper.MemberMapper;
import com.atguigu.ucenter.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author lzw
 * @since 2021-10-31
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService{

    @Override
    public String login(Member member){

        String mobile = member.getMobile();
        String password = member.getPassword();

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new GuliException(20001, "登录失败");
        }
        // 判断手机号是否正确
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Member mobileMember = baseMapper.selectOne(wrapper);
        // 判断手机号
        if (mobileMember == null) {
            throw new GuliException(20001, "手机号有错误");

        }
        // 判断密码
        if (! password.equals(mobileMember.getPassword())) {
            throw new GuliException(20001, "密码有错误");

        }

        // 用户是否禁用
        if (mobileMember.getIsDisabled()) {
            throw new GuliException(20001, "用户禁用有问题");

        }

        // 登录成功
        String token = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return token;
    }
}
