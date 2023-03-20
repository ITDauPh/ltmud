package server.database;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

	public static String get(String password) {
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			byte[] digest = md5.digest();
			BigInteger no = new BigInteger(1, digest);
			String sum = no.toString(16);
			// thêm vào đầu số 0 cho đủ 32 byte
			while (sum.length() < 32) {
				sum = "0" + sum;
			}
			return sum;
		} catch (NoSuchAlgorithmException e) {
		}

		return null;
	}
}
