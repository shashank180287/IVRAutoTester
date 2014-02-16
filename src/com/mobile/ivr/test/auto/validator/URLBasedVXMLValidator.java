package com.mobile.ivr.test.auto.validator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.mobile.ivr.test.auto.handler.VoiceXMLErrorHandler;
import com.mobile.ivr.test.auto.model.VoiceXMLValidationResult;
import com.mobile.ivr.test.auto.utils.LoggerExtension;

public class URLBasedVXMLValidator implements VoiceXMLValidator {

//	private static final String VOICEXML_SCHEMA_PATH = "http://www.w3.org/TR/voicexml20/vxml.xsd";
	private String inputVoiceXMLUrl;
	
	public URLBasedVXMLValidator(String inputVoiceXMLUrl) {
		this.inputVoiceXMLUrl = inputVoiceXMLUrl;
	}
	
	@Override
	public VoiceXMLValidationResult validate() {
		VoiceXMLValidationResult result = null;
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			factory.setNamespaceAware(true);

//			SchemaFactory schemaFactory = 
//			    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
//			factory.setSchema(schemaFactory.newSchema(new File("resourses/schema/vxml.xsd")));
			
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			VoiceXMLErrorHandler errorHandler = new VoiceXMLErrorHandler();
			reader.setErrorHandler(errorHandler);
			reader.parse(new InputSource(new URL(inputVoiceXMLUrl).openConnection().getInputStream()));
			result = errorHandler.getResult();
		} catch (ParserConfigurationException e) {
			LoggerExtension.log.warning("Error occured while validation Voice XML "+e.getMessage());
			result = new VoiceXMLValidationResult(e);
		} catch (MalformedURLException e) {
			LoggerExtension.log.warning("Error occured while validation Voice XML "+e.getMessage());
			result = new VoiceXMLValidationResult(e);
		} catch (IOException e) {
			LoggerExtension.log.warning("Error occured while validation Voice XML "+e.getMessage());
			result = new VoiceXMLValidationResult(e);
		} catch (SAXException e) {
			LoggerExtension.log.warning("Error occured while validation Voice XML "+e.getMessage());
			result = new VoiceXMLValidationResult(e);
		}
		return result;
	}

}
