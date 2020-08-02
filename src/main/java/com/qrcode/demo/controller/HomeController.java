package com.qrcode.demo.controller;


import com.qrcode.demo.util.QrCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping("/home")
@Controller
public class HomeController {

    @RequestMapping("/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response) {
        // 再加上请求链接
        //String requestUrl = tempContextUrl + "/index";
        String requestUrl = "http://www.baidu.com";
        try {
            OutputStream os = response.getOutputStream();
            //QrCodeUtil.encode(requestUrl, "/static/images/logo.jpg", os, true);
            QrCodeUtil.encode(requestUrl, "/data/springboot2/logo.jpg", os, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/qrnologo")
    public void qrnologo(HttpServletRequest request, HttpServletResponse response) {
        // 再加上请求链接
        //String requestUrl = tempContextUrl + "/index";
        String requestUrl = "http://www.baidu.com";
        try {
            OutputStream os = response.getOutputStream();
            //QrCodeUtil.encode(requestUrl, "/static/images/logo.jpg", os, true);
            QrCodeUtil.encode(requestUrl, null, os, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/qrsave")
    @ResponseBody
    public String qrsave() {
        // 再加上请求链接
        //String requestUrl = tempContextUrl + "/index";
        String requestUrl = "http://www.baidu.com";
        try {
            QrCodeUtil.save(requestUrl, "/data/springboot2/logo.jpg", "/data/springboot2/qrcode2.jpg",  true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "文件已保存";
    }
}
