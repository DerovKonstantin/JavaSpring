package ru.gb.homework_sem7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.gb.homework_sem7.service.AdminService;
import ru.gb.homework_sem7.service.HomeService;
import ru.gb.homework_sem7.service.UserService;

@Controller
public class HomeController {

	private final HomeService homeService;
	private final UserService userService;
	private final AdminService adminService;
	
	public HomeController(HomeService homeService, UserService userService, AdminService adminService) {
		this.homeService = homeService;
		this.userService = userService;
		this.adminService = adminService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("text", homeService.getText());
		return "index";

	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("text", adminService.getText());
		return "admin";
	}

    @GetMapping("/private-data")
	public String vip() {
		return "private-data";
	}

	@GetMapping("/public-data")
	public String pub() {
		return "public-data";
	}

	@GetMapping("/registr")
	public String reg() {
		return "registr";
	}
}
