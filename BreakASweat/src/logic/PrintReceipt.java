package logic;

public class PrintReceipt {
private String name;
private String address;
private String postcode;
private String telphone;
private String email;


public PrintReceipt(String name, String address, String postcode, String telphone, String email) {
	this.name = name;
	this.address = address;
	this.postcode = postcode;
	this.telphone = telphone;
	this.email = email;
}


public String getName() {
	return name;
}


public String getAddress() {
	return address;
}


public String getPostcode() {
	return postcode;
}


public String getTelphone() {
	return telphone;
}


public String getEmail() {
	return email;
}



}
