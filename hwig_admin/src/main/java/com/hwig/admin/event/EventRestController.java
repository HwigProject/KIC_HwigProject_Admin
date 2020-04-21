package com.hwig.admin.event;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/event")
public class EventRestController {

		@Inject
		EventService eService;
		
		@GetMapping("/event_square")
		public List<EventVO> event_square() throws Exception{
			
			return eService.event_square();
		}
		@GetMapping("/event_list")
		public List<EventVO> event_list() throws Exception{
			
			return eService.event_list();
		}
		@GetMapping("/event_banner")
		public List<EventVO> event_banner() throws Exception{
			
			return eService.event_banner();
		}
		@GetMapping("/event_content")
		public EventVO event_content(@RequestParam("event_id") int event_id) throws Exception{
			
			return eService.event_content(event_id);
		}
}
