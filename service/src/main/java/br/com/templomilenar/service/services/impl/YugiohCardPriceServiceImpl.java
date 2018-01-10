package br.com.templomilenar.service.services.impl;

import br.com.templomilenar.service.services.YugiohCardPriceService;
import br.com.templomilenar.vo.card.yugioh.YugiohCardPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class YugiohCardPriceServiceImpl implements YugiohCardPriceService {

    @Autowired
    @Qualifier("YGOCardPriceServiceImpl")
    private br.com.templomilenar.cardprice.serivce.yugioh.YGOCardPriceService service;

    @Override
    public YugiohCardPriceVO getCardPrice(final String printTag) {
        return service.getCardPrice(printTag);
    }

    @Override
    public double getHighestPrice(final String printTag) {
        return service.getHighestPrice(printTag);
    }

    @Override
    public double getLowestPrice(final String printTag) {
        return service.getLowestPrice(printTag);
    }

    @Override
    public double getAveragePrice(final String printTag) {
        return service.getAveragePrice(printTag);
    }

    @Override
    public LocalDateTime getUpdateDate(final String printTag) {
        return service.getUpdateDate(printTag);
    }


}
