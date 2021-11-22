package com.lzw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author a5071
 * @since 2021/11/19 18:35
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 下面倆註解用於配置文件中給Person賦值 注入組件
@Component
@ConfigurationProperties(prefix = "person")
public class Person{

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salary;
    private Map<String, List<Pet>> allPets;

}
