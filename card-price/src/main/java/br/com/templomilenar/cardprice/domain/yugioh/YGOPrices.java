package br.com.templomilenar.cardprice.domain.yugioh;

import br.com.templomilenar.cardprice.serivce.yugioh.YGOCardPriceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Top-level class of the JSON sent by Yugioh Prices API.
 * See {@link YGOCardPriceService} for detail
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YGOPrices {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private CardData cardData;
}
