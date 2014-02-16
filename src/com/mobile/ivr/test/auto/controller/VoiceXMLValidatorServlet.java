package com.mobile.ivr.test.auto.controller;

import java.io.IOException;

import javax.servlet.http.*;

import com.mobile.ivr.test.auto.service.XMLValidationService;

public class VoiceXMLValidatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4937646578411637151L;

	private XMLValidationService xmlValidationService = new XMLValidationService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String voiceXMLUrl = req.getParameter("url");
		if(voiceXMLUrl!=null && voiceXMLUrl.length()>0 && !"undefined".equalsIgnoreCase(voiceXMLUrl)){
			resp.getWriter().write(xmlValidationService.validateVoiceXMLURL(voiceXMLUrl));
		}else{
			resp.getWriter().write("{"
					+"\t\"status\" : \"Error\","
					+"\t\"message\" :\"Application Url can not be null\""
					+ "}");
		}
	}
}
