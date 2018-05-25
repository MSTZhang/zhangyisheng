package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.entity.Room;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.RoomService;
@Controller
public class RoomAction {
	@Resource
	private RoomService roomService;
	
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	//查询全部房间
	@RequestMapping(value="/room/select",method = RequestMethod.GET)
	@ResponseBody
	public Response select()  {
		List<Room> list = roomService.select();
		Response res = new Response();
		return res.success(list);
	}
	//根据房间id查找
	@RequestMapping(value="/room/findById",method = RequestMethod.GET)
	@ResponseBody
	public Response findById(Integer roomId){
		Room room1 = roomService.findById(roomId);
		System.out.println(roomId);
		Response res = new Response();
		return res.success(room1);
	}
	//修改房间状态
	@RequestMapping(value="/room/alterRmstus",method = RequestMethod.GET)
	@ResponseBody
	public Response alterRmstus(Integer rmStatus,Integer roomId){
		Room room = new Room();
		room.setRmStatus(rmStatus);
		room.setRoomId(roomId);
		roomService.alertStatus(room);
		Response res = new Response();
		return res.success();
	}
}
