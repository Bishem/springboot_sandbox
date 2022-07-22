package fr.diginamic.sandbox.repositories;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AnimalRepositoryTest {

	@Mock
	AnimalRepository repository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testFindFirst2BySpecieOrderByNameDesc() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFindByPersons() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFindByColorIn() {
		fail("Not yet implemented"); // TODO
	}

}
