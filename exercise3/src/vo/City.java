package vo;

public class City {
	private String cityName;
	private int cityCode;
	private int provinceCode;
	public City(String cityName, int cityCode, int provinceCode) {
		super();
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.provinceCode = provinceCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
