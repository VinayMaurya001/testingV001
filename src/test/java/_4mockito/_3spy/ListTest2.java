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

	@Test
	public void testSize() {
		List listMock =Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(10);
		Assertions.assertEquals(10, listMock.size());
		Assertions.assertEquals(10, listMock.size());
	}

	@Test
	public void testSize_multipleReturns() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(10).thenReturn(20);
		Assertions.assertEquals(10, listMock.size());
		Assertions.assertEquals(20, listMock.size());
		Assertions.assertEquals(20, listMock.size());
	}

	@Test
	public void testGet_SpecificParameter() {
		List listMock = Mockito.mock(List.class);
		Mockito.when(listMock.get(0)).thenReturn("SomeString");
		Assertions.assertEquals("SomeString", listMock.get(0));
		Assertions.assertEquals(null, listMock.get(1));
	}

	@Test
	public void testGet_GenericParameter() {
		List listMock = Mockito.mock(List.class);
		
		Mockito.when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");//Etiher we can use generic or specific means Mockito.anyInt() or 0.
		Assertions.assertEquals("SomeString", listMock.get(0));
		Assertions.assertEquals("SomeString", listMock.get(1));
	}
}
