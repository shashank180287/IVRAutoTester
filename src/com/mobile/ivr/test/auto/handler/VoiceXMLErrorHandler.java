package com.mobile.ivr.test.auto.handler;

import java.util.logging.Logger;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.mobile.ivr.test.auto.model.VoiceXMLValidationResult;

public class VoiceXMLErrorHandler implements ErrorHandler {

	private static final Logger log = Logger.getLogger(VoiceXMLErrorHandler.class.getName());
	private VoiceXMLValidationResult result;
	
	public VoiceXMLErrorHandler() {
		this.result = new VoiceXMLValidationResult();
	}
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		log.warning("Error : "+e.getMessage());
		result = new VoiceXMLValidationResult(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		log.warning("Fatal Error : "+e.getMessage());
		result = new VoiceXMLValidationResult(e);

	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		log.warning("Warning : "+e.getMessage());
		result = new VoiceXMLValidationResult(e);
	}

	public VoiceXMLValidationResult getResult() {
		return result;
	}
}
