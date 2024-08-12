package com.Instargram.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Instargram.post.bo.PostBO;
import com.Instargram.timeline.bo.TimelineBO;
import com.Instargram.timeline.domain.CardView;

@Controller
public class TimelineController {
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private TimelineBO timelineBO;

	///timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		
		//List<PostEntity> postList = postBO.getPostEntityList();
		//model에 담아서 뿌리기
		//model.addAttribute("postList", postList);
		
		//이제는 그냥 카드에 담아넣은거 뿌리면 된다
		List<CardView> cardViewList = timelineBO.generateCardViewList();
		
		model.addAttribute("cardViewList", cardViewList);

		//timeline.html로 이동
		return "timeline/timeline";
	}
}
