package com.xinfan.msgbox.core.vo;

public class Position {

	private final double EARTH_RADIUS = 6378137.0;

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

	public Position(String gpsx, String gpsy, String areaName) {
		this.gpsx = gpsx;
		this.gpsy = gpsy;
		this.areaName = areaName;
	}

	public int calcDistance(Position p) {

		try {

			double lat_a = Double.parseDouble(getGpsx());
			double lng_a = Double.parseDouble(getGpsy());

			double lat_b = Double.parseDouble(p.getGpsx());
			double lng_b = Double.parseDouble(p.getGpsy());

			return gps2m(lat_a, lng_a, lat_b, lng_b);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 10000;
	}

	public int gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
		double radLat1 = (lat_a * Math.PI / 180.0);
		double radLat2 = (lat_b * Math.PI / 180.0);
		double a = radLat1 - radLat2;
		double b = (lng_a - lng_b) * Math.PI / 180.0;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		
		return new Double(s).intValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position))
			return false;
		Position another = (Position) obj;

		return this.gpsx.equals(another.getGpsx()) && this.gpsy.equals(another.getGpsy());
	}
}
