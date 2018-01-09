package br.com.templomilenar.card_price.service;

import br.com.templomilenar.card_price.configuration.CardPriceModuleConfiguration;
import br.com.templomilenar.card_price.domain.CardPrice;
import br.com.templomilenar.card_price.serivce.CardPriceService;
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
public class CardPriceServiceTest {

    @MockBean
    private CardPriceService service;

    @Mock
    CardPrice mock;

    @Before
    public void setup() {
        when(service.getCardPrice(anyString())).thenReturn(mock);
        when(mock.getAverage()).thenReturn(10d);

        when(service.getMaxPrice(anyString())).thenReturn(20d);
        when(service.getLowPrice(anyString())).thenReturn(5d);
        when(service.getAveragePrice(anyString())).thenReturn(15d);
        when(service.getUpdateDate(anyString()))
                .thenReturn(LocalDateTime.of(2017, 1, 8,
                        15, 25, 44));
    }

    @Test
    public void shouldReturnCardPrice() {
        CardPrice price = service.getCardPrice("DOCS-EN001");
        assertEquals(10d, price.getAverage(), 0.0001);
    }

    @Test
    public void shouldReturnHighestPrice() {
        assertEquals(20d, service.getMaxPrice("DOCS-EN001"), 0.0001);
    }

    @Test
    public void shouldReturnLowestPrice() {
        assertEquals(5d, service.getLowPrice("DOCS-EN001"), 0.0001);
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
