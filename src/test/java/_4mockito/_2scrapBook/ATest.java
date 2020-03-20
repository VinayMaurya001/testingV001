package _4mockito._2scrapBook;

import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _4mockito._1orderService.bo.exception.BOException;

@RunWith(JUnitPlatform.class)
public class ATest {

	@Mock
	B b;

	private A a;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShoulCallTheVoidMethod() throws Exception {
		// a.usesVoidMethod();
		Mockito.doNothing().when(b).voidmethod();
		Assertions.assertSame(1, a.usesVoidMethod());
		Mockito.verify(b).voidmethod();
	}

	@Test
	public void usesVoidMethodShouldThrowRuntimeException() throws Exception {
		Mockito.doThrow(Exception.class).when(b).voidmethod();

		Assertions.assertThrows(BOException.class, () -> {
			a.usesVoidMethod();
		});

	}

	@Test
	public void testConsecutiveCalls() throws Exception {
		Mockito.doNothing().doThrow(Exception.class).when(b).voidmethod();
		a.usesVoidMethod();
		Mockito.verify(b).voidmethod();
		Assertions.assertThrows(BOException.class, () -> {
			a.usesVoidMethod();
		});

	}
}
