package com.entity;

public class Payment {
private int id;
private String cno;
private String cname;
private String expirem;
private String expirey;
private String cvv;
private String amount;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getExpirem() {
	return expirem;
}
public void setExpirem(String expirem) {
	this.expirem = expirem;
}
public String getExpirey() {
	return expirey;
}
public void setExpirey(String expirey) {
	this.expirey = expirey;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "Payment [id=" + id + ", cno=" + cno + ", cname=" + cname + ", expirem=" + expirem + ", expirey=" + expirey
			+ ", cvv=" + cvv + ", amount=" + amount + "]";
}


}
