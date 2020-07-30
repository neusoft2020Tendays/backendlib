package com.hitstu.oa.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitstu.oa.admin.model.UserModel;
import com.hitstu.oa.admin.service.IUserService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = { "*", "null" })
public class UserController {
	@Autowired
	private IUserService userService = null;
	@GetMapping("/validate")
	public Result<UserModel> validate(@RequestParam(required = true) String id,  @RequestParam(required = true) String password, HttpSession session) throws Exception{
		Result<UserModel> result = new Result<>();
		
		if (userService.validate(id, password)) {
			result.setStringResult("Yes");
			result.setResult(userService.getById(id));
			result.setMessage("管理员已验证成功");
			session.setAttribute("user", result.getResult());
		}
		else {
			result.setStringResult("NO");
			result.setMessage("管理员已验证失败");
		}
		result.setStatus("OK");
		return result;
	}
	
	
	@GetMapping("/checkLogin")
	public Result<String> checkLogin(HttpSession session) throws Exception{
		Result<String> result = new Result<>();
		if (session!=null&&session.getAttribute("user")!=null) {
			result.setStringResult("Yes");
			result.setStatus("OK");
			result.setMessage("管理员已登陆");
		}else {
			result.setStringResult("No");
			result.setStatus("OK");
			result.setMessage("管理员未登陆");
		}
		return result;
	}
	
	@GetMapping("/logout")
	public Result<String> Logout(HttpSession session) throws Exception{
		Result<String> result = new Result<>();
		session.invalidate();
		result.setStatus("OK");
		result.setMessage("管理员已经注销");
		return result;
	}
	
	@GetMapping("/get")
	public Result<UserModel>getById(@RequestParam(required = true) String id) throws Exception{
		Result<UserModel> result = new Result<>();
		result.setResult(userService.getById(id));
		result.setStatus("OK");
		result.setMessage("用户信息已获得");
		return result;
	}
	
	@PostMapping("/add")
	public Result<String>add(@RequestBody UserModel userModel) throws Exception{
		Result<String> result = new Result<>();
		UserModel uModel = userService.getById(userModel.getId());
		if (uModel != null) {
			result.setStringResult("No");
			result.setStatus("OK");
			result.setMessage("当前id已存在");
		}else {
			userService.addUser(userModel);
			result.setStringResult("Yes");
			result.setStatus("OK");
			result.setMessage("新用户已注册");
		}
		return result;
	}
	
}
