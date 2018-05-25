package com.zhangyisheng.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyisheng.annotation.IgnoreSecurity;
import com.zhangyisheng.entity.RoomType;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.RoomTypeService;

/**
 * 
 *房间类型操作
 */
@Controller
public class RoomTypeAction {
	@Resource
	private RoomTypeService roomTypeService;
	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}
	//查询所有房间
	@IgnoreSecurity
	@RequestMapping(value="/roomType/select",method=RequestMethod.GET)
	@ResponseBody
	public Response roomType(){
		List<RoomType>roomTypes = roomTypeService.select();
		Response res= new Response();
		return res.success(roomTypes);
	}
	//批量更新
	@RequestMapping(value="/roomType/updateBatch",method=RequestMethod.POST)
	@ResponseBody
	public Response updateBatch(@RequestBody List<RoomType> roomTypes){
		System.out.println(roomTypes);
		roomTypeService.updateBatch(roomTypes);
		Response res = new Response();
		return res.success();
	}
	//添加房间类型
	@RequestMapping(value="/roomType/add",method=RequestMethod.POST)
	@ResponseBody
	public Response add(@RequestBody RoomType roomType){
		System.out.println(roomType);
		Response res = new Response();
		roomTypeService.add(roomType);
		return res.success();
	}
	//删除房间类型
	@RequestMapping(value="/roomType/delete",method=RequestMethod.GET)
	@ResponseBody
	public Response delete(Integer roomTypeId){
		Response response = new Response();
		roomTypeService.delete(roomTypeId);
		return response.success();
	}
}
