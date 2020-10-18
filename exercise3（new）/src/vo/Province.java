package vo;

public class Province {
	private String provinceName;
	private int provinceCode;
	public Province(String provinceName, int provinceCode) {
		super();
		this.provinceName = provinceName;
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}
