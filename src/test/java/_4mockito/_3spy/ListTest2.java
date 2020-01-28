package _4mockito._3spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ListTest2 {

	@Mock
	ArrayList<String> myList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {
		myList.add("Vinay");
		myList.add("Abhinav");

		Mockito.when(myList.get(0)).thenReturn("Rambo");// No exception even if list is empty
		Assertions.assertSame("Rambo", myList.get(0));

		// Mockito.doReturn(3).when(myList).size();
		Mockito.when(myList.get(0)).thenCallRealMethod();
		Assertions.assertSame("Vinay",(String) myList.get(0));
	}

}
