package com.techinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String basicLoginDetails(){
        return  "logged into application";
    }

    @RequestMapping("/homepage")
    @ResponseBody
    public String homepageDetails(){
        return  "logged into application homepage - access to all users ";
    }

    @RequestMapping("/adminHomePage")
    @ResponseBody
    public String adminHomepageDetails(){
        return  "logged into application admin homepage - access to only ADMIN ";
    }


    @RequestMapping("/userHomePage")
    @ResponseBody
    public String userHomepageDetails(){
        return  "logged into application user homepage - access to only USERS ";
    }

}
