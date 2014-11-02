package com.xinfan.msgbox.vo;

public class Position {

	private String areaName;
	private String gpsx;
	private String gpsy;
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getGpsx() {
		return gpsx;
	}

	public void setGpsx(String gpsx) {
		this.gpsx = gpsx;
	}

	public String getGpsy() {
		return gpsy;
	}

	public void setGpsy(String gpsy) {
		this.gpsy = gpsy;
	}

	public Position(String gpsx, String gpsy) {
		this.gpsx = gpsx;
		this.gpsy = gpsy;
	}
	
	public Position(String gpsx, String gpsy,String areaName) {
		this.gpsx = gpsx;
		this.gpsy = gpsy;
		this.areaName = areaName;
	}
	
	public int calcDistance(Position p)
	{
		return 1000;
	}

}
