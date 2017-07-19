package com.ls.ltc.security.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ls.ltc.security.data.User;

@RestController
public class SecurityController {
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		User u = new User(Integer.MAX_VALUE, "wrong password", "no-role");
		HttpStatus status = HttpStatus.FORBIDDEN;
		if (username.equals(password)){
			u = new User(1, username, "admin");
			status = HttpStatus.OK;
		}
		return ResponseEntity
				.status(status)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
				.body(u);
	}
	
	@RequestMapping("/hello")
	public String view() {
		//String insurantHello = remoteRestTemplate.getForObject("http://insurant/hello", String.class);
		return "hello world";
	}
}
