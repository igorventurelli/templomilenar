package br.com.templomilenar.vo.card.yugioh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YugiohCardPriceVO {

    private String cardName;
    private String printTag;
    private double lowestPrice;
    private double highestPrice;
    private double averagePrice;
    private LocalDateTime updateDate;
}
