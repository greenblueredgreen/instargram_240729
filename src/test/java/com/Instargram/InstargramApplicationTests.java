package com.Instargram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InstargramApplicationTests {

	//@Test 주석을 해야만 실행이 된다
	@Test 
	void 더하기테스트(){
		int x = 15;
		int y = 20;
		assertEquals(x+y, 35);  
	}
	
	//class우클릭 -> run as -> junit test
	//초록색이 뜨면 잘 실행된다는 뜻이다
}
