package com.mygdx.game;
import org.junit.Test;
import static org.junit.Assert.*;

public class myTest {
    @Test
    public void testSum() {
        Tank tank = new Tank();
        Tank temp = tank.checkSelectedTank();
        assertEquals(temp, tank);
//        int value = MainMenu.add(1, 2);
//        assertEquals(3, value);
    }
}
