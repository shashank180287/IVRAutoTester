package com.mobile.ivr.test.auto.model;

public class VoiceXMLValidationResult {

	private boolean valid;
	private Throwable error;
	
	public VoiceXMLValidationResult() {
		super();
		this.valid = true;
	}
	
	public VoiceXMLValidationResult(Throwable error) {
		super();
		this.valid = false;
		this.error = error;
	}
	
	public VoiceXMLValidationResult(boolean valid, Throwable error) {
		super();
		this.valid = valid;
		this.error = error;
	}

	public boolean isValid() {
		return valid;
	}

	public Throwable getError() {
		return error;
	}

	public String toJSON() {
		return "{"
		+"\t\"status\" : \"" + (valid?"Success":"Error")+"\","
		+"\t\"message\" :\"" + (error!=null? error.getMessage():"") +"\""
		+ "}";
	}
}
