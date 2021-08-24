package org.geogebra.common.gui.view.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.geos.GeoList;
import org.junit.Before;
import org.junit.Test;

public class TableValuesInputProcessorTest extends BaseUnitTest {

	private TableValuesInputProcessor processor;
	private GeoList list;

	@Before
	public void setUp() {
		processor = new TableValuesInputProcessor(getConstruction());
		list = new GeoList(getConstruction());
	}

	@Test
	public void testValidInput() {
		try {
			processor.processInput("1", list, 0);
			processor.processInput("2", list, 1);
			processor.processInput("99.9", list, 2);
			processor.processInput("0.01", list, 3);
			processor.processInput("", list, 4);
			processor.processInput("20e-2", list, 6);
			processor.processInput("10", list, 10);
			assertThat(list.size(), is(11));
			assertValue("1", 0);
			assertValue("2", 1);
			assertValue("99.9", 2);
			assertValue("0.01", 3);
			assertValue("?", 4);
			assertValue("?", 5);
			assertValue("0.2", 6);
			assertValue("10", 10);
		} catch (InvalidInputException e) {
			fail("Must not throw an exception");
		}
	}

	private void assertValue(String value, int index) {
		assertThat(list.getListElement(index).toString(StringTemplate.defaultTemplate), is(value));
	}

	@Test(expected = NullPointerException.class)
	public void testNullInput() throws InvalidInputException {
		processor.processInput(null, list, 0);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidInputWithComma() throws InvalidInputException {
		processor.processInput("10,2", list, 0);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidInputWithOperators() throws InvalidInputException {
		processor.processInput("10 + 2", list, 0);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidInputWithLetters() throws InvalidInputException {
		processor.processInput("a", list, 0);
	}
}
