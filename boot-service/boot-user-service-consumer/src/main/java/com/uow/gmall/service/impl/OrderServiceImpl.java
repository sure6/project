package com.uow.gmall.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.uow.gmall.bean.UserAddress;
import com.uow.gmall.service.OrderService;
import com.uow.gmall.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
//    @Resource
    @Reference
    UserService userService;

    public List<UserAddress> initOrder(String userID) {
        System.out.println("当前接收到的userId=> "+userID);
        //查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userID);

        return userAddressList;
    }
}
