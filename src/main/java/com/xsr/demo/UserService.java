package com.xsr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 145811 on 2018/1/31.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepo;


}
