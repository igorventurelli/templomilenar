package br.com.templomilenar.cardprice.service.yugioh;

import br.com.templomilenar.cardprice.configuration.CardPriceModuleConfiguration;
import br.com.templomilenar.cardprice.serivce.yugioh.YGOCardPriceService;
import br.com.templomilenar.vo.card.yugioh.YugiohCardPriceVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CardPriceModuleConfiguration.class})
public class YGOCardPriceServiceTest {

    @MockBean
    private YGOCardPriceService service;

    @Mock
    YugiohCardPriceVO mock;

    @Before
    public void setup() {
        when(service.getCardPrice(anyString())).thenReturn(mock);
        when(mock.getAveragePrice()).thenReturn(10d);

        when(service.getHighestPrice(anyString())).thenReturn(20d);
        when(service.getLowestPrice(anyString())).thenReturn(5d);
        when(service.getAveragePrice(anyString())).thenReturn(15d);
        when(service.getUpdateDate(anyString()))
                .thenReturn(LocalDateTime.of(2017, 1, 8,
                        15, 25, 44));
    }

    @Test
    public void shouldReturnCardPrice() {
        YugiohCardPriceVO price = service.getCardPrice("DOCS-EN001");
        assertEquals(10d, price.getAveragePrice(), 0.0001);
    }

    @Test
    public void shouldReturnHighestPrice() {
        assertEquals(20d, service.getHighestPrice("docs-en001"), 0.0001);
    }

    @Test
    public void shouldReturnLowestPrice() {
        assertEquals(5d, service.getLowestPrice("DOCS-EN001"), 0.0001);
    }

    @Test
    public void shouldReturnAveragePrice() {
        assertEquals(15d, service.getAveragePrice("DOCS-EN001"), 0.0001);
    }

    @Test
    public void shouldReturnLastUpdate() {
        LocalDateTime expected = LocalDateTime.of(2017, 1, 8,
                15, 25, 44);
        assertEquals(expected, service.getUpdateDate("DOCS-EN001"));
    }

}
