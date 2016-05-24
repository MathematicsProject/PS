package spring.project.server;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.project.convert.*;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String notice(Locale locale, Model model,
			HttpServletRequest request) {
		
		String equation = request.getParameter("String");
		
		MathematicaConvert mm = new MathematicaConvert();
		mm.setequation(equation);
		mm.calcMathematica();
		String expr = mm.getexpr();
		String encode1 = mm.getencoded();
		String encode2 = mm.getencoded2();
		
		model.addAttribute("expr", expr);							
		model.addAttribute("encode1", encode1);
		model.addAttribute("encode2", encode2);
		return "results";	
	}
	
	@RequestMapping(value = "/ocr", method = RequestMethod.GET)
	public String ocr(Locale locale, Model model,
			HttpServletRequest request) {

		TesseractExample mm = new TesseractExample();
		String expr = mm.ocr();
		model.addAttribute("expr", expr);							
		
		return "ocr";
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(Locale locale, Model model,
			HttpServletRequest request) {					
		
		return "confirmEquation";	
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test(@RequestParam("string") String a) {					
		if(a==null)
			return "fail";
		return "http://113.198.80.233/PS/";	
	}
}
