package _4mockito._3spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class ListTest {

	@Spy
	List<String> myList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {
		myList.add("Vinay");
		myList.add("Abhinav");

		// Mockito.when(myList.get(0)).thenReturn("Rambo");//RTE, IndexOutOfBounds exception may occur, if list is empty
		Mockito.doReturn(3).when(myList).size();
		Assertions.assertSame(3, myList.size());
	}

}
