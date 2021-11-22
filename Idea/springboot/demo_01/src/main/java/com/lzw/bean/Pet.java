package com.lzw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author a5071
 * @since 2021/11/19 18:38
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet{

    private String name;
    private Double weight;
}
