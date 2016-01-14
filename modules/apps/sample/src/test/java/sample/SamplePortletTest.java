package sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SamplePortletTest {

	@Before
	public void setUp() {
		System.out.println("Invoking setUp()");
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Invoking setUpBeforeClass()");
	}

	@After
	public void tearDown() {
		System.out.println("Invoking tearDown()");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Invoking tearDownAfterClass()");
	}

	@Ignore
	@Test
	public void testIgnore() {
		System.out.println("Test ignored");

		Assert.assertTrue(false);
	}

	@Test
	public void testSample() {
		System.out.println("Sample Test");

		Assert.assertTrue(true);
	}

	@Test(expected = RuntimeException.class)
	public void testSampleThrowsException() {
		throw new RuntimeException();
	}

}