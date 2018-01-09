package br.com.templomilenar.card_price.serivce.impl;

import br.com.templomilenar.card_price.domain.*;
import br.com.templomilenar.card_price.serivce.CardPriceService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * Implementation of {@link CardPriceService}
 *
 * @author igorventurelli
 * @since 1.0.0
 */
@Component
public class CardPriceServiceImpl implements CardPriceService {

    private RestTemplate template;

    public CardPriceServiceImpl() {
        this.template = new RestTemplate();
    }

    @Override
    public CardPrice getCardPrice(final String printTag) {
        YGOPrices ygoPrices = template.getForObject(YGO_PRICES_API + printTag, YGOPrices.class);
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

        cardPrice.setPrintTag(setData.getPrintTag());
        return cardPrice;
    }

    @Override
    public double getMaxPrice(final String printTag) {
        CardPrice cardPrice = getCardPrice(printTag);
        return cardPrice != null ? cardPrice.getMax() : -1d;
    }

    @Override
    public double getLowPrice(final String printTag) {
        CardPrice cardPrice = getCardPrice(printTag);
        return cardPrice != null ? cardPrice.getLow() : -1d;
    }

    @Override
    public double getAveragePrice(final String printTag) {
        CardPrice cardPrice = getCardPrice(printTag);
        return cardPrice != null ? cardPrice.getAverage() : -1d;
    }

    @Override
    public LocalDateTime getUpdateDate(final String printTag) {
        CardPrice cardPrice = getCardPrice(printTag);
        return cardPrice != null ? cardPrice.getLastUpdateAsLocalDateTime() : null;
    }
}
