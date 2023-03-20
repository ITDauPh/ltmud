package message.dto;

import message.Message;

// gửi thông tin tài khoản giữa client và server
public class AccountDTO extends Message {
	private static final long serialVersionUID = 1L;
	private server.dto.AccountDTO account;
	private String chuoithua;
	private String chuoithang;

	public AccountDTO() {
		account = new server.dto.AccountDTO();
	}

	public server.dto.AccountDTO getAccount() {
		return account;
	}

	public void setAccount(server.dto.AccountDTO account) {
		this.account = account;
	}

	public String toString() {
		if (account != null)
			return account.getUsername();
		return "no content";
	}
}

//	private static final long serialVersionUID = 1L;
//	private int id;
//	private String ho;
//	private String ten;
//	private boolean gioitinh;
//	private Date ngaysinh;
//	private String email;
//	private String username;
//	private String password;
//	// thêm chuỗi thắng, chuỗi thua, ...
//
//	public int getId() {
//		return id;
//	}
//
//	public String getHo() {
//		return ho;
//	}
//
//	public void setHo(String ho) {
//		this.ho = ho;
//	}
//
//	public String getTen() {
//		return ten;
//	}
//
//	public void setTen(String ten) {
//		this.ten = ten;
//	}
//
//	public boolean isGioitinh() {
//		return gioitinh;
//	}
//
//	public void setGioitinh(boolean gioitinh) {
//		this.gioitinh = gioitinh;
//	}
//
//	public Date getNgaysinh() {
//		return ngaysinh;
//	}
//
//	public void setNgaysinh(Date ngaysinh) {
//		this.ngaysinh = ngaysinh;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//}
