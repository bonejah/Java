package codility;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CodilityTest {

	Codility codility;

	public void before() {
		this.codility = new Codility();
	}

	@Test
	public void test01() {
		// Example test: [1, 3, 6, 4, 1, 1] The smallest is: 5
		int a[] = { 1, 3, 6, 4, 1, 1 };

		int expected = 5;
		int result = Codility.solution(a);

		assertEquals(expected, result);
	}

	@Test
	public void test02() {
		// Example test: [1, 2, 3] The smallest is: 0
		int a[] = { 1, 2, 3 };

		int expected = 0;
		int result = Codility.solution(a);

		assertEquals(expected, result);
	}

	@Test
	public void test03() {
		// Example test: [-1, -3] The smallest is: -2
		int a[] = { -1, -3 };

		int expected = -2;
		int result = Codility.solution(a);

		assertEquals(expected, result);
	}

}
