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
import com.zhangyisheng.entity.CheckIn;
import com.zhangyisheng.response.Response;
import com.zhangyisheng.service.CheckInService;
import com.zhangyisheng.service.RoomService;
@Controller
public class CheckInAction {
	@Resource
	private CheckInService checkInService;
	public void setCheckInService(CheckInService checkInService) {
		this.checkInService = checkInService;
	}
	@RequestMapping(value="/checkIn/add",method=RequestMethod.POST,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response addCheckInfo(@RequestBody CheckIn checkIn){
		System.out.println(checkIn.getCheckTime());
		int i = checkInService.add(checkIn);
		Response res = new Response();
		return res.success();
	}
	//根据房间号查找入住信息
	@RequestMapping(value="/checkIn/findByRmId",method=RequestMethod.GET,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response findByRmId(Integer roomId){
		CheckIn cin= checkInService.findByRmId(roomId);
		System.out.println(cin);
		Response res = new Response();
		return res.success(cin);
	}
	//获取订单总金额
	@RequestMapping(value="/checkIn/totalPrice",method=RequestMethod.GET,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response totalPrice(String checkNum){
		Double totalPrice = checkInService.totalPrice(checkNum);
		Response res = new Response();
		return res.success(totalPrice);
	}
	//结账退房
	@RequestMapping(value="/checkIn/balance",method=RequestMethod.GET,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response balance(String checkNum){
		System.out.println("结账单号"+checkNum);
		checkInService.balance(checkNum);
		Response res = new Response();
		return res.success();
	}
	//查询全部
	@RequestMapping(value="/checkIn/select",method=RequestMethod.GET,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response select(){
		Response res = new Response();
		List<CheckIn> list = checkInService.select();
		return res.success(list);
	}
	//根据入住单号查找入住信息
	@RequestMapping(value="/checkIn/findByCheckNum",method=RequestMethod.GET,produces = "application/json", 
            consumes = "application/json")
	@ResponseBody
	public Response findByCheckNum(String checkNum){
		Response res =new Response();
		CheckIn checkIn = checkInService.findByCId(checkNum);
		return res.success(checkIn);
	}
}
