package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.service.ItemsService;

@Controller
public class LoginController {

	@Autowired
	private ItemsService itemsService;
	
	// 登陆
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password,	Model model) throws Exception {

		String encryPw = itemsService.getEncryPass(password);
		//session.setAttribute("username", username);
		model.addAttribute("username", username);
		model.addAttribute("initPw", password);
		model.addAttribute("encryPw", encryPw);
		System.out.println("encryPw=" + encryPw);

		ModelAndView modelAndView = new ModelAndView();
		/*
		 * modelAndView.addObject("user", "username");
		 * modelAndView.setViewName("success");
		 */
		return "success";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {

		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

}
