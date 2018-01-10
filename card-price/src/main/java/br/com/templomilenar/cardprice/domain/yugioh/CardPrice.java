package br.com.templomilenar.cardprice.domain.yugioh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Card Price domain class
 *
 * @author igorventurelli
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPrice {

    private String printTag;

    @JsonProperty("high")
    private double highestPrice;

    @JsonProperty("low")
    private double lowestPrice;

    @JsonProperty("average")
    private double averagePrice;

    @JsonProperty("updated_at")
    private String updateDate;

    /**
     * Return the <code>lastUpdate</code> String field as {@link LocalDateTime}
     *
     * @return The last update date of the price for this card
     */
    public LocalDateTime getLastUpdateAsLocalDateTime() {
        return LocalDateTime.parse(updateDate, DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss Z"));
    }
}
