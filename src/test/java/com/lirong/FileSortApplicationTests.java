package com.lirong;

import org.junit.Test;

import java.util.Optional;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FileSortApplicationTests {

	@Test
	public void contextLoads() {

		Optional<Integer> optional1 = Optional.ofNullable(1);
		Optional<Integer> optional2 = Optional.ofNullable(null);

// orElse
		System.out.println(optional1.orElse(1000) == 1);// true
		System.out.println(optional2.orElse(1000) == 1000);// true
	}

}
