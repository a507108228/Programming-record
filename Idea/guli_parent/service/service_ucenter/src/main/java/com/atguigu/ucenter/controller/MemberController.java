package com.atguigu.ucenter.controller;


import com.atguigu.commonutils.R;
import com.atguigu.ucenter.entity.Member;
import com.atguigu.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author lzw
 * @since 2021-10-31
 */
@Api(description = "登录")
@RestController
@RequestMapping("/ucenter/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "登录")
    @GetMapping("login")
    public R loginUser(@RequestBody Member member){
        // 调用service方法登录
        // 返回token 使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token", token);
    }


    @ApiOperation(value = "注册")
    public R zhuce(){

        return R.ok();
    }

}

