package com.atguigu.ucenter.service.impl;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.MD5;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.ucenter.entity.Member;
import com.atguigu.ucenter.entity.vo.RegisterVo;
import com.atguigu.ucenter.mapper.MemberMapper;
import com.atguigu.ucenter.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

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
        // 输入的密码先加密在和数据库比较
        if (! MD5.encrypt(password).equals(mobileMember.getPassword())) {
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

    // 注册的方法
    @Override
    public void register(RegisterVo registerVo){
        // 获取注册的数据
        String nickname = registerVo.getNickname();

        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();

        String code = registerVo.getCode();


        // 非空判断
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(code) || StringUtils.isEmpty(nickname)){
            throw new GuliException(20001, "登录失败");
        }

        // 判断验证码 获取redis验证码
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!code.equals(redisCode)) {
            throw new GuliException(2001, "注册失败");
        }

        // 判断手机号是否重复， 表里面存有相同手机号不添加
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count > 0){
            throw new GuliException(2001, "注册失败");
        }

        // 数据添加数据库中
        Member member = new Member();
        member.setMobile(mobile);
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        baseMapper.insert(member);


    }


    @Override
    public Member getOpenIdMember(String openid){
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        Member member = baseMapper.selectOne(wrapper);
        return member;
    }
}
