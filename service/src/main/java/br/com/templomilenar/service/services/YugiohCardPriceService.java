package br.com.templomilenar.service.services;

import br.com.templomilenar.vo.card.yugioh.YugiohCardPriceVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public interface YugiohCardPriceService {

     /** Returns the {@link YugiohCardPriceVO} of the card
      *
      * @param printTag of the card
      * @return If the card is found returns the
      * {@link YugiohCardPriceVO} instance.
      * If not, returns <code>null</code>
      */
    YugiohCardPriceVO getCardPrice(final String printTag);

    /**
     * Returns the highest price of the card
     *
     * @param printTag of the card
     * @return If the card if found returns the highest price.
     * If not, returns <code>-1d</code>
     */
    double getHighestPrice(final String printTag);

    /**
     * Returns the lowest price of the card
     *
     * @param printTag of the card
     * @return If the card if found returns the lowest price.
     * If not, returns <code>-1d</code>
     */
    double getLowestPrice(final String printTag);

    /**
     * Returns the average price of the card
     *
     * @param printTag of the card
     * @return If the card if found returns the average price.
     * If not, returns <code>-1d</code>
     */
    double getAveragePrice(final String printTag);

    /**
     * Returns the Last Update date of the price of the card
     * @param printTag of the card
     * @return If the card is found returns the
     * Last Update date of the price of the card.
     * If not, returns <code>null</code>
     */
     LocalDateTime getUpdateDate(final String printTag);
}
