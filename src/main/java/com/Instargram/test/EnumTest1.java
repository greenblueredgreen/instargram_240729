package com.Instargram.test;

import lombok.Getter;

public class EnumTest1 {
	
	@Getter
	public enum Status {
		//열거형 정의
		Y(1, true), 
		N(0, false);
		
		// enum에 정의된 항목 필드 
		private int value1;
		private boolean value2;
		
		//생성자 
		Status(int value1, boolean value2){
			this.value1 = value1;
			this.value2 = value2;
		}
		
	}
	
	//@Test
	void status테스트() {
		//given - 준비
		Status status = Status.Y;
		
		//when - 실행
		int value1 = status.getValue1();
		boolean value2 = status.isValue2();
		
		//then- 검증
		//assertEquals(1, value1);
		//assertEquals(true, value2);
		//assertEquals(status, Status.Y);
	}
	
}
