package com.ls.ltc.security.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ls.ltc.security.data.Constants;
import com.ls.ltc.security.data.User;

@RestController
public class SecurityController {
	private static Logger log = LoggerFactory.getLogger(SecurityController.class);
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		log.info("logging in {}", username);
		
		User u = new User(Integer.MAX_VALUE, "wrong password", "no-role");
		HttpStatus status = HttpStatus.FORBIDDEN;
		if (username.equals(password)){
			u = new User(1, username, "admin");
			status = HttpStatus.OK;
		}
		log.info("{} logged in {}", username, status);
		return ResponseEntity
				.status(status)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.body(u);
	}
	
	@GetMapping("/ping")
	public ResponseEntity<Map<String, String>> sayHello(HttpServletRequest request) {
		Map<String, String> ret = new HashMap<>();
		ret.put(Constants.LTC_CURRENT_USER_ID, "" + request.getHeader(Constants.LTC_CURRENT_USER_ID));
		ret.put(Constants.LTC_CURRENT_USER_ROLE, "" + request.getHeader(Constants.LTC_CURRENT_USER_ROLE));
		ret.put(Constants.LTC_CURRENT_REQUEST_TS, "" + request.getHeader(Constants.LTC_CURRENT_REQUEST_TS));
		ret.put("content", "ping in security");
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.body(ret);
	}
}
