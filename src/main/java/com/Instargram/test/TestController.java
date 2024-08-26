package com.Instargram.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Instargram.test.mapper.TestMapper;

@Controller
public class TestController {
	
	@Autowired
	TestMapper testMapper;
	
	@ResponseBody
    @RequestMapping("/test1")
    public String helloWorld() {
        return "Hello world!";
    }
  
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<>();
		map.put("a", 1111);
		map.put("b", 1112);
		map.put("c", 1113);
		return map;
	}
	
	@GetMapping("/test3")
	public String test3() {
		// templates/test/test3.html
		return "test/test1";
	}
	
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4() {
		return testMapper.selectTest(); 
		//json return 
	}
	
	//@Test
	void 메소드레퍼런스() {
		List<String> fruits = List.of("apple", "banana", "cherry");
		
		//fruits = fruits.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
		
		fruits = fruits.stream().map(String :: toUpperCase) // element -> element.toUpperCase() 
		.collect(Collectors.toList());
		
		//log.info("%%%% {}", fruits);
	}
}
