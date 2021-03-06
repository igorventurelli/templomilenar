package br.com.templomilenar.cardprice.domain.yugioh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceData {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private PriceDetail priceDetail;
}
