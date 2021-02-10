package by.prohorov.price.km;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CostByPriceKmImplTest {

    private CostByPriceKmImpl costKm;

    @BeforeEach
    void init() {
        costKm = new CostByPriceKmImpl();

}

    @Test
    void costByPriceInKm_returnValue() {
        
        costKm.setCostDistance(new BigDecimal(25));
        BigDecimal value = costKm.costByPriceInKm();
        assertEquals(6.25, value.doubleValue());
        assertNotEquals(value, 18);
    }
}