package br.com.templomilenar.view.controller;

import br.com.templomilenar.service.services.YugiohCardPriceService;
import br.com.templomilenar.vo.card.yugioh.YugiohCardPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YugiohCardPriceController {

    @Autowired
    @Qualifier("yugiohCardPriceServiceImpl")
    private YugiohCardPriceService service;

    @RequestMapping("/yugioh-card-price")
    public String index() {
        return "yugioh-card-price";
    }

    @RequestMapping("/yugioh-card-price/query")
    public ModelAndView getPrice(@RequestParam("printTag") String printTag) {
        ModelAndView mv = new ModelAndView("yugioh-card-price");

        YugiohCardPriceVO vo = service.getCardPrice(printTag);
        if(vo == null) {
            mv.addObject("cardNotFound","Carta não encontrada: ");
            mv.addObject("originalPrintTag", printTag);
        } else {
            mv.addObject("price", "US$" + vo.getAveragePrice());
            mv.addObject("finalPrintTag", vo.getPrintTag());
            mv.addObject("cardName", vo.getCardName() + " - ");
        }

        return mv;
        //return "forward:/yugioh-card-price";
    }
}
