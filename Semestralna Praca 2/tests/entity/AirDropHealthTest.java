package entity;

import hlavnaTrieda.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 29/03/2022 - 12:54
 *
 * @author 2karo
 */
class AirDropHealthTest {
    private AirDropHealth airDropHealth;
    private Delo delo;

    @BeforeEach
    void setUp() {
        this.delo = new Delo(10, 1, null);
        this.airDropHealth = new AirDropHealth(20);
        airDropHealth.pouzi(delo);
    }
        @AfterEach
        void tearDown() {
            System.out.println("koniec");
    }
        @Test
        void pouzi() {
            Assertions.assertEquals(425 ,this.delo.getZivoty() );

        }

    }
