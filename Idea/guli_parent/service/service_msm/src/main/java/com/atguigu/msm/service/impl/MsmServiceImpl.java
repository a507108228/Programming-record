package com.atguigu.msm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.atguigu.msm.service.MsmService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Map;

/**
 * @author a5071
 * @since 2021/10/31 16:02
 * description:
 */
@Service
public class MsmServiceImpl implements MsmService{

    // 发送验证码 param验证码 phone手机号
    @Override
    public boolean send(Map<String, Object> param, String phone){
        if (StringUtils.isEmpty(phone)) return false;
        DefaultProfile profile = DefaultProfile
                .getProfile("default", "LTAI5tDqohp9MK1jX1PoRy7T", "XaG4tmiKA3SxXaMVSszi3R0iSoTrJV");

        DefaultAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2021-10-31");
        request.setAction("SendSms");

        // 发送相关的参数 TODO 签名名称，模板code
        request.putQueryParameter("PhoneNumbers", phone);
        // 签名名称需要修改
        request.putQueryParameter("SignName", "签名名称");
        request.putQueryParameter("TemplateCode", "模板code");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));


        try {
            CommonResponse response = client.getCommonResponse(request);
            boolean success = response.getHttpResponse().isSuccess();
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
