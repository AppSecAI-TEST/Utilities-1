package org.hse.demo.minbucket;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class TestClassTest {

	@Test
	public void test() {
		assertThat("wrong", 1, Matchers.isOneOf(3,4,5));
		fail("Not yet implemented");
	}

}
