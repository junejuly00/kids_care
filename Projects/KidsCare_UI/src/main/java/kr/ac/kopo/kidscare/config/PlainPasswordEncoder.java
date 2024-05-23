package kr.ac.kopo.kidscare.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		//System.out.println(rawPassword + ", "+ encodedPassword);
		
		if (encode(rawPassword).equals(encodedPassword)) {
			return true;
		}
		return false;
	}

}
