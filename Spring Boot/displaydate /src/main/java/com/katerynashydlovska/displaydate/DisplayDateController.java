package com.katerynashydlovska.displaydate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
		}
	
	
	@RequestMapping("/time")
	public String time(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateString = dateFormat.format(new Date()).toString();
		model.addAttribute("time",dateString);
		return "Time.jsp";
		}
	
	
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDate date = LocalDate.now();
		String day = getDayStringNew(date, Locale.US);
		
		//2021-06-14
		String[] parts = date.toString().split("-");
		String month = theMonth(Integer.valueOf(parts[1]));

		
		 model.addAttribute("date", day + ", the " +  parts[2] + " of " + month + ", " + parts[0]);
		return "DateTime.jsp";
		}
	
	
	public static String getDayStringNew(LocalDate date, Locale locale) {
	    DayOfWeek day = date.getDayOfWeek();
	    return day.getDisplayName(TextStyle.FULL, locale);
	}
	
	public static String theMonth(int month){
	    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	    return monthNames[month];
	}
}
