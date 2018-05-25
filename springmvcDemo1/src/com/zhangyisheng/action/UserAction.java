package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.entity.RoomType;
import com.zhangyisheng.entity.User;
import com.zhangyisheng.service.RoomTypeService;

@Controller
public class UserAction {
	@Resource
	RoomTypeService roomTypeService;
	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}

	@RequestMapping("/index")
	@IgnoreSecurity
	@ResponseBody
	public List<RoomType> index(Model model){
		List<RoomType>rtys = roomTypeService.select();
		System.out.println(rtys);
		model.addAttribute("user", "小张");
		System.out.println("请求到达");
		User user = new User(1,"张义胜","14111202073","123123","1754817041@qq.com",1);
		return rtys;
	}
}
