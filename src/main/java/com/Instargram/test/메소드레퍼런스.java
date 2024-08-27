package com.Instargram.test;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class 메소드레퍼런스 {

	@ToString
	@AllArgsConstructor
	public class Person{
		private String name;
		private int age;
		
		public void printInfo() {
			log.info("### {} ", this);
		}
	}
	
	//@Test
	void 메소드레퍼런스테스트() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("신보람", 30));
		people.add(new Person("콩콩", 15));
		
		//객체 안에 있는 메소드 호출
		//people.forEach(p -> p.printInfo()); //람다
		//people.forEach(Person::printInfo); //메소드 레퍼런스
		
		//객체를 println으로 출력하기
		//people.forEach(p -> System.out.println(p));  //람다식 출력
		//people.forEach(System.out :: println); //메소드 레퍼런스
	}
}

