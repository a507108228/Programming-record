package com.lzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a5071
 * @since 2021/11/20 19:04
 * description
 */
@Controller
public class RequestController{

    @GetMapping("/goto")
    public String toPage(HttpServletRequest request){
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");

        Map<String, Object> map = new HashMap<>();
        map.put("requestGetMsg", msg1);
        map.put("requestGetCode", code1);
        map.put("annotationMsg", msg);
        map.put("annotationCode", code);

        return map;
    }
}
