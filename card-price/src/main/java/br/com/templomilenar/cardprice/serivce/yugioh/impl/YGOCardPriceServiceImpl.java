package br.com.templomilenar.cardprice.serivce.yugioh.impl;

import br.com.templomilenar.cardprice.domain.yugioh.*;
import br.com.templomilenar.cardprice.serivce.yugioh.YGOCardPriceService;
import br.com.templomilenar.vo.card.yugioh.YugiohCardPriceVO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * Implementation of {@link YGOCardPriceService}
 *
 * @author igorventurelli
 * @since 1.0.0
 */
@Component
public class YGOCardPriceServiceImpl implements YGOCardPriceService {

    private static final String PRINT_TAG_CODE_SEPARATOR = "-";
    private static final String API_CARD_LANGUAGE = "EN";

    private RestTemplate template;

    public YGOCardPriceServiceImpl() {
        this.template = new RestTemplate();
    }

    @Override
    public YugiohCardPriceVO getCardPrice(final String printTag) {
        if(printTag == null || printTag.equals("")) { return null; }

        final String preparedPrintTag = preparePrintTag(printTag);
        if(preparedPrintTag == null) { return null; }

        YGOPrices ygoPrices = template.getForObject(YGO_PRICES_API + preparedPrintTag, YGOPrices.class);
        if(ygoPrices == null) { return null; }

        CardData cardData = ygoPrices.getCardData();
        if(cardData == null) { return null; }

        SetData setData = cardData.getSetData();
        if(setData == null) { return null; }

        PriceData priceData = setData.getPriceData();
        if(priceData == null) { return null; }

        PriceDetail priceDetail = priceData.getPriceDetail();
        if(priceDetail == null) { return null; }

        CardPrice cardPrice = priceDetail.getCardPrice();
        if(cardPrice == null) { return null; }

        if(!preparedPrintTag.equals(setData.getPrintTag())) { return null; }

        return new YugiohCardPriceVO(
                cardData.getName(),
                setData.getPrintTag(),
                cardPrice.getLowestPrice(),
                cardPrice.getHighestPrice(),
                cardPrice.getAveragePrice(),
                cardPrice.getLastUpdateAsLocalDateTime());
    }

    @Override
    public double getHighestPrice(final String printTag) {
        YugiohCardPriceVO vo = getCardPrice(printTag);
        return vo != null ? vo.getHighestPrice() : -1d;
    }

    @Override
    public double getLowestPrice(final String printTag) {
        YugiohCardPriceVO vo = getCardPrice(printTag);
        return vo != null ? vo.getLowestPrice() : -1d;
    }

    @Override
    public double getAveragePrice(final String printTag) {
        YugiohCardPriceVO vo = getCardPrice(printTag);
        return vo != null ? vo.getAveragePrice() : -1d;
    }

    @Override
    public LocalDateTime getUpdateDate(final String printTag) {
        YugiohCardPriceVO vo = getCardPrice(printTag);
        return vo != null ? vo.getUpdateDate() : null;
    }

    private String preparePrintTag(final String printTag) {
        if(printTag.indexOf(PRINT_TAG_CODE_SEPARATOR) == -1) { return null; }

        StringBuilder finalPrintTag = new StringBuilder(printTag.substring(
                0, printTag.indexOf(PRINT_TAG_CODE_SEPARATOR) + 1));

        finalPrintTag.append(API_CARD_LANGUAGE); //API have only english card in their database

        final String printTagSuffix = printTag.substring(printTag.indexOf(
                PRINT_TAG_CODE_SEPARATOR) + API_CARD_LANGUAGE.length() + 1);

        finalPrintTag.append(printTagSuffix);

        return finalPrintTag.toString().toUpperCase();
    }
}
