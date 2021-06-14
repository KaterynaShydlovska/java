package com.katerynashydlovska.counter;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		 Integer count = (Integer) session.getAttribute("count");
		 if(count == null) {
			 count = 0;
		 }
		 count++;
		 session.setAttribute("count", count);
			model.addAttribute("counter",  count);
	    
		return "index.jsp";
		}
	
	@RequestMapping("/counter")
	public String counter() {
		return "Counter.jsp";
		}
	
//    public String sessionData(HttpSession session){
//        session.setAttribute("count", 0);
//        Integer count = (Integer) session.getAttribute("count");
//        System.out.println("" + count);
//        
//        return "" + count;
//    }

}
