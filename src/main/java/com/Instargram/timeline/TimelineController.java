package com.Instargram.timeline;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimelineController {

	///timeline/timeline-view
	@GetMapping("/timeline/timeline-view")
	public String timelineView() {
		return "timeline/timeline";
	}
}
