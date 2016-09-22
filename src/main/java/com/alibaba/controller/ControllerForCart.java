package com.alibaba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.DAO.RegisterDAO;
import com.alibaba.model.Register;

@Controller
public class ControllerForCart {
	@Autowired
	RegisterDAO registerDAO;
	
	@RequestMapping("/")
	public String index()
	{
		System.out.println("index called");
		return "index";
	}
	@RequestMapping("/login")

	public String login()
	{
		System.out.println("login called");
		return "login";
	}
	@RequestMapping("/logout")

	public String logout()
	{
		System.out.println("logout called");
		return "logout";
	}

	@RequestMapping("/register")

	public ModelAndView register()
	{
		System.out.println("register called");
		Register reg= new Register();
		return new ModelAndView("register","reg",reg);
	}
	@RequestMapping("/registerUser")

	public ModelAndView registerUser(@Valid @ModelAttribute("reg")Register register,BindingResult bindingresult)//Validations are stored in BindingResult
	{
		if(bindingresult.hasErrors())
		{
			System.out.println("errors found...");
			return new ModelAndView("register");
		}
		registerDAO.registerUser(register);
		System.out.println("registerUser called");
		return new ModelAndView("registerUser","info","successfully registered");
	}

}
