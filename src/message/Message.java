package message;

import java.io.Serializable;

// dùng để gửi qua lại giữa client và server

public class Message implements Serializable {
	private String request;
	// request: đăng nhập, đăng ký, ...
	
	private String username;
	private String password;
	
	// gioi tinh, ngay sinh, ...
	
	public static void main(String[] args) {
		
	}

	public Message(String username, String password) {
		this.request = "đăng nhập";
		this.username = username;
		this.password = password;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return username + " " + password;
	}
}
