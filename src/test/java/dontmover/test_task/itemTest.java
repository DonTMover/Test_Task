package dontmover.test_task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemTest {

    @Test
    void getId() {
        item item = new item("10","15");
        assertEquals("10",item.getId());
    }

    @Test
    void setId() {
        item item = new item("10","15");
        item.setId("11");
        assertEquals("11",item.getId());
    }

    @Test
    void getAmount() {
        item item = new item("10","15");
        assertEquals("15",item.getAmount());
    }

    @Test
    void setAmount() {
        item item = new item("10","15");
        item.setAmount("20");
        assertEquals("20",item.getAmount());
    }
}