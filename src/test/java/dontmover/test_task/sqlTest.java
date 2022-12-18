package dontmover.test_task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class sqlTest {
    @Test
    void getConnection() {
        //Нечего проверять
    }

    @Test
    void allQuery() {

    }

    @Test
    void addToCards() {
        assertTrue(sql.AddToCards(9999, 1, "Test", "Test"));
    }

    @Test
    void addToItems() {
        assertTrue(sql.AddToItems(9999, "Test", 9999));
    }

    @Test
    void whereQuery() {
        //Сравнивать ResultSet-ы бесполезно
    }
}