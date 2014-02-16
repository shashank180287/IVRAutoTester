package com.mobile.ivr.test.auto.service;

import com.mobile.ivr.test.auto.validator.URLBasedVXMLValidator;
import com.mobile.ivr.test.auto.validator.VoiceXMLValidator;

public class XMLValidationService {

	private VoiceXMLValidator voiceXMLValidator;
	
	public String validateVoiceXMLURL(String voiceXmlUrl){
		voiceXMLValidator = new URLBasedVXMLValidator(voiceXmlUrl);
		return voiceXMLValidator.validate().toJSON();
	}
}
