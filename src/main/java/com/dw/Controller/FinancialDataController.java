package com.dw.Controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FinancialDataController {
	private Logger logger = Logger.getLogger(FinancialDataController.class);
	
	@RequestMapping(value = "/financial", method = RequestMethod.GET)
	public ModelAndView financial(HttpServletRequest request) {
		logger.info(" Financial Data ");
		
		ModelAndView mv = new ModelAndView("financial");
		return mv;
	}
	
	@RequestMapping(value = "/consultaAPI", method = RequestMethod.POST)
	public @ResponseBody String consultaAPI(HttpServletRequest request, @RequestBody String param) {
		final String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=5min&apikey=demo";

		RestTemplate restTemplate = new RestTemplate();
		String respuesta = restTemplate.getForObject(uri, String.class);
		System.out.println(respuesta);
		return respuesta;
	}

}