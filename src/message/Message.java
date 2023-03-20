package message;

import java.io.Serializable;

public abstract class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String request;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}

// dùng để gửi qua lại giữa client và server
//public class Message implements Serializable {
//	private String request;
//	// request: đăng nhập, đăng ký, thống kê, nhận bài, gửi bài,...
//	// TODO: sửa thành interface
//	private AccountDTO account;
//
//	public Message(AccountDTO account) {
//		this.request = "đăng nhập";
//		this.account = account;
//	}
//
//	public AccountDTO getAccount() {
//		return account;
//	}
//
//	public void setAccount(AccountDTO account) {
//		this.account = account;
//	}
//
//	public String getRequest() {
//		return request;
//	}
//
//	public void setRequest(String request) {
//		this.request = request;
//	}
//
//	public String toString() {
//		return account.getUsername();
//	}
//}
