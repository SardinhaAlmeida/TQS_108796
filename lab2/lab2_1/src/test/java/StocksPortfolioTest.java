import stocks_portfolio.IStockmarketService;
import stocks_portfolio.Stock;
import stocks_portfolio.StocksPortfolio;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {

    @Mock
    IStockmarketService market;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    public void SetUp(){
        portfolio = new StocksPortfolio(market);
    }

    @DisplayName("Test total value")
    @Test
    public void testTotalValue(){

        when(market.lookUpPrice("Azeite")).thenReturn(30.0);
        when(market.lookUpPrice("Carne Picada")).thenReturn(9.0);
        
        portfolio.addStock(new Stock("Azeite", 2));
        portfolio.addStock(new Stock("Carne Picada", 3));

        //assertEquals(87.0, portfolio.totalValue());
        assertThat(portfolio.totalValue(), equalTo(87.0));

        verify(market).lookUpPrice("Azeite");
        verify(market).lookUpPrice("Carne Picada");
    }

}
