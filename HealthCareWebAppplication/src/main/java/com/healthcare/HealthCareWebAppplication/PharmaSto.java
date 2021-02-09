package com.healthcare.HealthCareWebAppplication;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PharmaSto {
	
	String Icode;
	String Iname;
	String PackSize;
	String LineNo;
	String SupPrice; 
	String SupDiscount;
	String CostPrice;
	String WholeSalePrice;
	String Date;
	String Selling;
	
	
	public String getIcode() {
		return Icode;
	}
	public void setIcode(String icode) {
		Icode = icode;
	}
	public String getLineNo() {
		return LineNo;
	}
	public void setLineNo(String lineNo) {
		LineNo = lineNo;
	}
	public String getSupPrice() {
		return SupPrice;
	}
	public void setSupPrice(String supPrice) {
		SupPrice = supPrice;
	}
	public String getSupDiscount() {
		return SupDiscount;
	}
	public void setSupDiscount(String supDiscount) {
		SupDiscount = supDiscount;
	}
	public String getCostPrice() {
		return CostPrice;
	}
	public void setCostPrice(String costPrice) {
		CostPrice = costPrice;
	}
	public String getWholeSalePrice() {
		return WholeSalePrice;
	}
	public void setWholeSalePrice(String wholeSalePrice) {
		WholeSalePrice = wholeSalePrice;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public String getPackSize() {
		return PackSize;
	}
	public void setPackSize(String packSize) {
		PackSize = packSize;
	}
	public String getSelling() {
		return Selling;
	}
	public void setSelling(String selling) {
		Selling = selling;
	}
	
	
	@Override
	public String toString() {
		return "PharmaSto [Icode=" + Icode + ", Iname=" + Iname + ", PackSize=" + PackSize + ", LineNo=" + LineNo
				+ ", SupPrice=" + SupPrice + ", SupDiscount=" + SupDiscount + ", CostPrice=" + CostPrice
				+ ", WholeSalePrice=" + WholeSalePrice + ", Date=" + Date + ", Selling=" + Selling + "]";
	}
	
	
	
	

}
