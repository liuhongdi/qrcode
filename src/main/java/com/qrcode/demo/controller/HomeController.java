package com.qrcode.demo.controller;

import com.qrcode.demo.util.QrCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@RequestMapping("/home")
@Controller
public class HomeController {

    //生成带logo的二维码到response
    @RequestMapping("/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response) {
        String requestUrl = "http://www.baidu.com";
        try {
            OutputStream os = response.getOutputStream();
            QrCodeUtil.encode(requestUrl, "/data/springboot2/logo.jpg", os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //生成不带logo的二维码到response
    @RequestMapping("/qrnologo")
    public void qrnologo(HttpServletRequest request, HttpServletResponse response) {
        String requestUrl = "http://www.baidu.com";
        try {
            OutputStream os = response.getOutputStream();
            QrCodeUtil.encode(requestUrl, null, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //把二维码保存成文件
    @RequestMapping("/qrsave")
    @ResponseBody
    public String qrsave() {
        String requestUrl = "http://www.baidu.com";
        try {
            QrCodeUtil.save(requestUrl, "/data/springboot2/logo.jpg", "/data/springboot2/qrcode2.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "文件已保存";
    }
}
