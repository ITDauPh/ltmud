package client.bus;

import java.io.IOException;
import java.net.UnknownHostException;

import client.dao.AccountDAO;
import message.dto.AccountDTO;

// Xử lí logic, ví dụ xác nhận OTP
public class AccountBUS {
	private AccountDAO accountDao;
	private AccountDTO accountDto;

	public AccountBUS() {
	}

	public boolean dangNhap(String username, String password) throws UnknownHostException, IOException {
		if (accountDao == null) {
			connect();
		}

		accountDto = accountDao.dangNhap(username, password);

		return accountDto != null;
	}

	public boolean dangKy(AccountDTO accontDto) {
		// OTP handle
		return false;
	}

	private void connect() throws UnknownHostException, IOException {
		accountDao = new AccountDAO();
	}

	public void close() {
		accountDao.close();
	}
}
