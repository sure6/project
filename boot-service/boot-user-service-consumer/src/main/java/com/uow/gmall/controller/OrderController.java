package com.uow.gmall.controller;

import com.uow.gmall.bean.Cervaluation;
import com.uow.gmall.bean.UserAddress;
import com.uow.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;



    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId){
        return orderService.initOrder(userId);
    }

    @ResponseBody
    @RequestMapping("/getEvaluations")
    public List<Cervaluation> getCervalutions(){
        return orderService.getCervaluationList();
    }
}
