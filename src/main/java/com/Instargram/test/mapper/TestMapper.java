package com.Instargram.test.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	public List<Map<String, Object>> selectTest();
}
