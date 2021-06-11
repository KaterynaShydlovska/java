package com.katerynashydlovska.routs;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {

    @RequestMapping("/{dojo}")
    public String dojo(@PathVariable String dojo){
    	if(dojo.equals("dojo")) {
    		return "The " + dojo + " is awsome";
    	}else if (dojo.equals("burbank-dojo")) {
        	return "Burbank Dojo is locates in South California";
    	}else if(dojo.equals("san-jose")) {
        	return  "SJ dojo is the headquarters";
    		
    	}else {
    		return "This is the wrong route!";
    	}
    		
    	}
    	
}


