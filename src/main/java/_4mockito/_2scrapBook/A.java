package _4mockito._2scrapBook;


public class A {

	private B b;

	public A(B b) {
		this.b = b;
	}

	public int usesVoidMethod() {
		try {
			b.voidmethod();
		} catch (Exception e) {
			throw new RuntimeException();
		}

		return 1;
	}
}
