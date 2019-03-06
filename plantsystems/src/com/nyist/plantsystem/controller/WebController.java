package com.nyist.plantsystem.controller;

import com.nyist.plantsystem.model.loginAccount;
import com.nyist.plantsystem.service.plantSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@Controller
public class WebController {
    @Autowired
    private plantSystemService plantSystemService;

//    登陆页面访问入口
    @RequestMapping("Login")
    public String Login(){
        return "Login";
    }

    public WebController() {
    }

//    登陆Action
    @RequestMapping("LoginAction")
    public String LoginAction(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        return "";
    }

    @RequestMapping("CreateCode")
    public void CreateCode(HttpServletResponse response) throws IOException {
        // 验证码字符个数
        int codeCount = 4;
        char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        // 创建一个随机数生成器类
        Random random = new Random();
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }

        System.out.println(randomCode);
        PrintWriter out = response.getWriter();
        out.print(randomCode);
    }

    /**
     * 用户登陆模块
     * */
    @RequestMapping("insertLoginAccountAction")
    public void insertLoginAccountAction(){
        int id = 1;
        String username = "lhg";
        String password = "123456";
        loginAccount loginAccount = new loginAccount();
        loginAccount.setId(id);
        loginAccount.setUsername(username);
        loginAccount.setPassword(password);
        System.out.println("**********************************");
        plantSystemService.insertLoginAccount(loginAccount);
        System.out.println("添加用户成功");
    }
}
