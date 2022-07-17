package com.uow.gmall.service;



import com.uow.gmall.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressList(String userId);
}
