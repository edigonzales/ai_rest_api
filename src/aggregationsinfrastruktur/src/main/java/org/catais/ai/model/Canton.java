package org.catais.ai.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Canton {

	private int id;
	
	private int fosnr;
	
	private String code;
	
	private String name;
	
//	public Canton(int id, String code, String name) {
//		this.id = id;
//		this.code = code;
//		this.name = name;
//	}

	public Canton() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getFosnr() {
		return fosnr;
	}
	
	public void setFosnr(int fosnr) {
		this.fosnr = fosnr;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}