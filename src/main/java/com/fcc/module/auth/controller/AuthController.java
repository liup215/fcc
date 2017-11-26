package com.fcc.module.auth.controller;

import com.fcc.common.constant.tip.Tip;
import com.fcc.module.auth.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by acer on 2017/11/24.
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IAuthService authService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Tip register(@RequestParam String username,@RequestParam String password,@RequestParam String passwordConfirm){
        return authService.register(username,password,passwordConfirm);
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public Tip stateLessLogin(@RequestParam String username,@RequestParam String password){
        return authService.stateLessLogin(username,password);
    }

    @RequestMapping("/check")
    @ResponseBody
    public Tip authCheck(@RequestParam String authorization){
        return authService.authCheck(authorization);
    }
}
