package com.atguigu.ucenter.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.ucenter.entity.Member;
import com.atguigu.ucenter.entity.vo.RegisterVo;
import com.atguigu.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
    @PostMapping("login")
    public R loginUser(@RequestBody Member member){
        // 调用service方法登录
        // 返回token 使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token", token);
    }


    @ApiOperation(value = "注册")
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo){
memberService.register(registerVo);
        return R.ok();
    }


    // 根据token获取用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        // 根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        // 查询数据库根据用户id获取用户信息
        Member member = memberService.getById(memberId);
        return R.ok().data("userInfo", member);
    }

}

