package br.com.templomilenar.view.controller;

import br.com.templomilenar.card_price.serivce.CardPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CardPriceController {

    @Autowired
    @Qualifier("cardPriceServiceImpl")
    private CardPriceService service;

    @RequestMapping("/card-price")
    public String index() {
        return "card-price";
    }

    @RequestMapping("/card-price/query")
    public String getPrice(@RequestParam("printTag") String printTag, Model model) {
        final double average = service.getAveragePrice(printTag);
        model.addAttribute("average", average);
        return "forward:/card-price";
    }
}
