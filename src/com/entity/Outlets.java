package com.entity;

//物流网点
public class Outlets {

	private Integer id;//主键
	
	private String oname;//物流网点名称

	private String province;//省

	private String city;//市

	private String address;//详细地址

	private String phone;//联系电话

	private String personincharge;//物流网点负责人

	private String remark;//备注

	private String ctime;//添加时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonincharge() {
		return personincharge;
	}

	public void setPersonincharge(String personincharge) {
		this.personincharge = personincharge;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
}
