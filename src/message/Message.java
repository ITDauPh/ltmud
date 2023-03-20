package message;

import java.io.Serializable;

import message.dto.AccountDTO;

// dùng để gửi qua lại giữa client và server
public class Message implements Serializable {
	private String request;
	// request: đăng nhập, đăng ký, thống kê, nhận bài, gửi bài,...
	// TODO: sửa thành interface
	private AccountDTO account;

	public Message(AccountDTO account) {
		this.request = "đăng nhập";
		this.account = account;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String toString() {
		return account.getUsername();
	}
}
