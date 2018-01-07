package br.com.templomilenar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/home")
    @ResponseBody
    public String index() {
        return "funciona multi module templo milenar!";
    }
}
