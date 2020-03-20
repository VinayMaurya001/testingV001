package _2junit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GreetingImplTest {

	private Greeting greeting;
	

	@Before
	public void setup() {
		System.out.println("Setup");
		greeting = new GreetingImpl();

	}

	@Test
	public void greetShouldRetunAValidOutput() {
		System.out.println("greetShouldRetunAValidOutput");
		String result = greeting.greet("Junit");
		Assert.assertNotNull(result);
		Assert.assertEquals("Hello Junit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		greeting.greet(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		greeting.greet("");
	}

	@After
	public void teardown() {
		greeting = null;
	}

}
