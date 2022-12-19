package dontmover.test_task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemBuilderImplTest {

    @Test
    void setAmount() {
        item item = new itemBuilderImpl().setAmount("10").build();
        assertEquals("10",item.amount);
    }

    @Test
    void setId() {
        item item = new itemBuilderImpl().setId("10").build();
        assertEquals("10",item.id);
    }

    @Test
    void setPromotional() {
        item item = new itemBuilderImpl().setPromotional(true).build();
        assertTrue(item.promotional);
    }

    @Test
    void build() {
        item item1 = new itemBuilderImpl().build();
        assertTrue(item1 instanceof item);
    }
}