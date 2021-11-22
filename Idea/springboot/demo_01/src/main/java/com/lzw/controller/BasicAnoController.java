package com.lzw.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author a5071
 * @description
 * @since 2021/11/20 15:33
 */
@RestController
@CrossOrigin
@RequestMapping("ba")
public class BasicAnoController{

    // @PathVariable 获取@GetMapping中的属性
    @GetMapping("car/{id}/{name}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("name") String name,
                                      @PathVariable Map<String, String> mp,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters")List<String> inters,
                                      @RequestParam Map<String, Object> params
                                      ){

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("mp", mp);

        map.put("User-Agent", userAgent);
        map.put("header", header);


        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);

        return map;

    }

    // post 获取表单上的信息
    @PostMapping("save")
    public Map postSave(@RequestBody String context){

        Map<String, Object> map = new HashMap<>();
        map.put("context", context);
        return map;

    }


}
