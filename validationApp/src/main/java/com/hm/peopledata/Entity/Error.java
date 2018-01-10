package com.hm.peopledata.Entity;

public class Error {

    private String messageid;
    private String gcid;
    private String country;
    private String xmlMess;
	private String errortext;

    public Error(String messageid, String gcid, String country, String xmlMess, String errortext) {
        this.messageid = messageid;
        this.gcid = gcid;
        this.country = country;
        this.xmlMess = xmlMess;
        this.errortext = errortext;
    }

    public Error(){}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getGcid() {
		return gcid;
	}

	public void setGcid(String gcid) {
		this.gcid = gcid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getXmlMess() {
		return xmlMess;
	}

	public void setXmlMess(String xmlMess) {
		this.xmlMess = xmlMess;
	}
    public String getErrortext() {
		return errortext;
	}

	public void setErrortext(String errortext) {
		this.errortext = errortext;
	}

}
