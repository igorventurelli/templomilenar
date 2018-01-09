package br.com.templomilenar.card_price.serivce;

import br.com.templomilenar.card_price.domain.CardPrice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Service that verify the prices of a card
 *
 * @author igorventurelli
 * @since 1.0.0
 */
@Service
public interface CardPriceService {

    /**
     * Yugioh Prices API endpoint
     */
    static final String YGO_PRICES_API = "http://yugiohprices.com/api/price_for_print_tag/";

    /**
     * Returns the {@link CardPrice} of the card
     *
     * @param printTag of the card
     * @return If the card is found returns the
     * Highest, Lowest and Average prices as {@link CardPrice}.
     * If not, returns <code>null</code>
     */
    CardPrice getCardPrice(final String printTag);

    /**
     * Returns the highest price of the card
     *
     * @param printTag of the card
     * @return If the card if found returns the highest price.
     * If not, returns <code>-1d</code>
     */
    double getMaxPrice(final String printTag);

    /**
     * Returns the lowest price of the card
     *
     * @param printTag of the card
     * @return If the card if found returns the lowest price.
     * If not, returns <code>-1d</code>
     */
    double getLowPrice(final String printTag);

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
