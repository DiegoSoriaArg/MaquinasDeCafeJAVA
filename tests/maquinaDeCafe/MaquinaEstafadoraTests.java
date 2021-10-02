package maquinaDeCafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEstafadoraTests {

	MaquinaDeCafe maquina;
	
	@Before
	public void setup() {
		maquina = new MaquinaEstafadora();
	}
	
	@Test
	public void queDevuelveunVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		assertNotNull(vaso);
	}
	
	@Test
	public void quePuedeServirUnCafe() {
		maquina.servirCafe();
		assertTrue(maquina.puedeServir());
	}
	
	@Test
	public void queElPrimerVasoEstaLlenoYElSiguienteVacio() {
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());
		assertTrue(maquina.servirCafe().estaLleno());
		assertFalse(maquina.servirCafe().estaLleno());
	}
	
	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		assertFalse(maquina.puedeServir());
	}
	
	@Test
	public void queNoSeAgotaElCafe() {
		VasoDeCafe vaso = null;
		for (int i = 0; i < 199; i++) {
			vaso = maquina.servirCafe();
		}
		assertTrue(vaso.estaLleno());
	}
	
	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i< 200; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLleno());
	}

}
