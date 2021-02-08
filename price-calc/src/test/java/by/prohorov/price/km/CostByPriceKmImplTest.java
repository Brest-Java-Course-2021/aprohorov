package by.prohorov.price.km;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostByPriceKmImplTest {

    private CostByPriceKmImpl costKm;

    @BeforeEach
    void init() {
        costKm = new CostByPriceKmImpl();
}

    @Test
    void costByPriceInKm_returnValue() {
        costKm.setCostDistance(25);
        double value = costKm.costByPriceInKm();
        assertEquals(6.25, value);
        assertNotEquals(value, 18);
    }
}