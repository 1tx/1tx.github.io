package com.entity;

//物流信息
public class Logistics {

	private Integer id;//主键

	private Integer expressId;//关联的快递id
	
	private String lcontent;//物流信息内容

	private String ctime;//添加时间


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public String getLcontent() {
		return lcontent;
	}

	public void setLcontent(String lcontent) {
		this.lcontent = lcontent;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
}
