package spring.project.server;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

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
		//asdf
		return "test";
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String API(Locale locale, Model model, HttpServletRequest request) {
		AlphaAPISample sample = new AlphaAPISample();
		ArrayList<String> resultURL = new ArrayList<String>();
		ArrayList<String> getTitle = new ArrayList<String>();
		String inputData = request.getParameter("string");
		sample.connetAPI(getTitle, resultURL, inputData);
		
		//return "test";
		request.setAttribute("getTitle", getTitle);
		request.setAttribute("resultURL", resultURL);
		return "s";
	}
	
	@RequestMapping(value = "/ocr", method = RequestMethod.GET)
	public String ocr(Locale locale, Model model,
			HttpServletRequest request, HttpSession session) {
		
		String PJpath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/tessdata";
		String outputpath = session.getServletContext().getRealPath("/") + "WEB-INF/output/";
		String imapath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/samples/20160531232347739.jpg";
		
		System.out.println(imapath);
		TesseractExample mm = new TesseractExample();
		String expr = mm.ocr(PJpath, imapath,outputpath);
		model.addAttribute("expr", expr);							
		
		return "ocr";
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(Locale locale, Model model,
			HttpServletRequest request) {					
		
		return "confirmEquation";	
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String test(@RequestParam("string") String a, HttpServletRequest request, HttpSession session) {					
		if(a==null)
			return "fail"; //http://113.198.80.233/PS/
		String img = null;
		String imapath = session.getServletContext().getRealPath("/") + "WEB-INF/samples/";
		String outputpath = session.getServletContext().getRealPath("/") + "WEB-INF/output/";
		String PJpath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/tessdata";
		writeFile w = new writeFile();
		try {
			//System.out.println(w.writeFile(a, imapath));
			img = w.writeFile(a, imapath);
			System.out.println(img);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TesseractExample mm = new TesseractExample();
		String fullimagepath = imapath+img;
		String expr = mm.ocr(PJpath, fullimagepath, outputpath);
		
		return expr;
		//return "12+12";
	}
	@RequestMapping(value = "/tae", method = RequestMethod.POST)
	public @ResponseBody String tae(@RequestParam("string") String a, HttpServletRequest request, HttpSession session) {					
		if(a==null)
			return "fail"; //http://113.198.80.233/PS/
				
		return "sin(x)";
		//return "12+12";
	}
}
