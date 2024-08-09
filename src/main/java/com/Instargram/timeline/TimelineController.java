package com.Instargram.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Instargram.post.bo.PostBO;
import com.Instargram.post.entity.PostEntity;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;

	///timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		
		List<PostEntity> postList = postBO.getPostEntityList();
		
		//model에 담아서 뿌리기
		model.addAttribute("postList", postList);
		//timeline.html로 이동
		return "timeline/timeline";
	}
}
