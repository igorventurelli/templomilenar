package br.com.templomilenar.card_price.domain;

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
    private double max;

    @JsonProperty("low")
    private double low;

    @JsonProperty("average")
    private double average;

    @JsonProperty("updated_at")
    private String lastUpdate;

    /**
     * Return the <code>lastUpdate</code> String field as {@link LocalDateTime}
     *
     * @return The last update date of the price for this card
     */
    public LocalDateTime getLastUpdateAsLocalDateTime() {
        return LocalDateTime.parse(lastUpdate, DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss Z"));
    }
}
