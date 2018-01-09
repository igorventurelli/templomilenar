package br.com.templomilenar.view.controller;

import br.com.templomilenar.service.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private HomeService service;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return service.getMessage();
    }
}
