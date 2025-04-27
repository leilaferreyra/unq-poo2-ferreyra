package ar.edu.unq.poo2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class CounterTest {
    private Counter c; // No debe ser redeclarada en setUp()

    @BeforeEach
    void setUp() { // Método sin 'public' en JUnit 5
        c = new Counter(new ArrayList<>(Arrays.asList(1, 2, 8,16,20,5,3))); // Corrige la inicialización
    }

    @Test
    public void paresTest() {
        assertEquals(4, c.cantidadPares(),"Falla la cantidad de pares");
    }
    @Test 
    public void imparesTest() {
    	assertEquals(3,c.cantidadImpares(),"Falla cantidad de impares");

    }
    @Test 
    public void multiplosTest() {
    	assertEquals(3,c.cantidadMultiplosDe(4),"Falla cantidad de multiplos");
    }
    @Test 
    public void multiplosMaximoTest() {
    	assertEquals(999, c.multiploMax(3, 9));
    }
}