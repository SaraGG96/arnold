package edu.teamrocket;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ArnoldEnumTypeTest {

	public static String[] planetas;

	@BeforeAll
	public static void CreacionArrayPlanetasSetup() {
		planetas = new String[8];
		int planetasIncluidos = 0;
		for (Planeta planeta : Planeta.values()) {
			planetas[planeta.ordinal()] = planeta.name();
			planetasIncluidos += 1;
		}
		assertEquals(Planeta.values().length, planetasIncluidos);
		for (String planeta : planetas) {
			assertNotNull(planeta);
		}
	}

	@Test
	public void PlanetaConstructorTest() {
		Planeta planeta = Planeta.MERCURY;
		assertInstanceOf(Planeta.class, planeta);
		assertEquals(0, planeta.ordinal());
		assertEquals("MERCURY", planeta.name());
		assertEquals(Planeta.MERCURY, Planeta.valueOf(planeta.name()));
		assertEquals(0, planeta.compareTo(Planeta.MERCURY));
		assertEquals("MERCURY", planeta.toString());
		assertTrue(planeta.equals(Planeta.MERCURY));
		assertEquals(planeta, Planeta.values()[0]);
	}

	@Test
	public void PlanetaGetMasaTest() {
		Planeta planeta = Planeta.MERCURY;
		assertEquals(3.303e+23, planeta.getMasa());
	}

	@Test
	public void PlanetaGetRadioTest() {
		Planeta planeta = Planeta.MERCURY;
		assertEquals(2.4397e+6, planeta.getRadio());
	}

	@Test
	public void PlanetaNamesIteratorTest() {
		for (Planeta planeta : Planeta.values()) {
			assertTrue(Arrays.asList(planetas).contains(planeta.name()));
		}
	}

	@Test
	public void PesoSuperficieMercurioTest() {
		Planeta planeta = Planeta.MERCURY;
		double pesoHumano = 175;
		assertEquals(648.0296765190394, planeta.pesoSuperficie(pesoHumano), 0.001);
	}

	@Test
	public void ArrayPlanetasTerrestresTest() {

		String[] planetasTerrestres = new String[4];
		int planetasIncluidos = 0;

		for (int i = Planeta.MERCURY.ordinal(); i < Planeta.JUPITER.ordinal(); i++) {
			planetasTerrestres[i] = Planeta.values()[i].name();
			planetasIncluidos += 1;
		}
		assertEquals(4, planetasIncluidos);
		for (String planetaTerrestre : planetasTerrestres) {
			assertNotNull(planetaTerrestre);
		}

		for (Planeta planeta : Planeta.getPlanetasTerrestres()) {
			assertTrue(Arrays.asList(planetasTerrestres).contains(planeta.name()));
		}
	}

	@Test
	public void ArrayGigantesGaseosos() {

		String[] gigantesGaseosos = new String[4];
		int planetasIncluidos = 0;

		byte index = 0;
		for (int i = Planeta.JUPITER.ordinal(); i <= Planeta.NEPTUNE.ordinal(); i++) {
			gigantesGaseosos[index] = Planeta.values()[i].name();
			planetasIncluidos += 1;
			index += 1;
		}
		assertEquals(4, planetasIncluidos);
		for (String giganteGaseoso : gigantesGaseosos) {
			assertNotNull(giganteGaseoso);
		}

		for (Planeta planeta : Planeta.getGigantesGaseosos()) {
			assertTrue(Arrays.asList(gigantesGaseosos).contains(planeta.name()));
		}
	}
}
