package com.ls.ltc.security.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ls.ltc.security.data.User;

@RestController
public class UserRestController {
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(@RequestParam("group") String group, @RequestParam("insurant") User user) {
		System.out.println("Registered group " + group + " user " + user.getName());
	}
}
