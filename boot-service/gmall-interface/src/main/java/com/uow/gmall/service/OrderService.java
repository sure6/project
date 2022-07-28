package com.uow.gmall.service;

import com.uow.gmall.bean.Cervaluation;
import com.uow.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService {
    public List<UserAddress> initOrder(String userID);

    public List<Cervaluation> getCervaluationList();
}
