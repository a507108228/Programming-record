package com.lzw.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author a5071
 * @since 2021/12/4 16:58
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {

    private Integer code;//状态码
    private String msg;//异常信息

    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}
