package dev.jpa.chat;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeCont {

	public HomeCont() {
		System.out.println("-> HomeCont created.");
	}

	@GetMapping(value="/read") // http://localhost:9096
    public String home() { // 파일명 return
	  System.out.println("/에 들어옴");
       return "chatting/chat"; // /templates/index.html  
  }

}
