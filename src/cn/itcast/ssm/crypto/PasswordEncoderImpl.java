package cn.itcast.ssm.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {
	private MessageDigest messageDigest;
	
	public PasswordEncoderImpl(String algorithm) throws NoSuchAlgorithmException {
		super();
		
		messageDigest = MessageDigest.getInstance(algorithm);
	}

	public String encode(CharSequence rawPassword) {
		try {
			byte[] encodedBytes = messageDigest.digest(rawPassword.toString().getBytes("UTF-8"));
			
			StringBuffer encodedPassword = new StringBuffer();
			
			int numBytes = encodedBytes.length;
			String hex;
			
			for (int index = 0; index < numBytes; ++index) {
				hex = Integer.toHexString(0xff & encodedBytes[index]);
				
				if (hex.length() == 1) encodedPassword.append("0");
				encodedPassword.append(hex);
			}
			
			return encodedPassword.toString();
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encode(rawPassword).equals(encodedPassword);
	}

}
