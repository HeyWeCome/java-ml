package com.kang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kang.pojo.Provincial;
import com.kang.service.provincial.ProvincialService;
import com.kang.service.provincial.ProvincialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/13 15:09
 * @version: 1.0
 */

@Controller
@RequestMapping("/provincial")
public class ProvincialController {
    @Autowired
    private ProvincialService provincialService = new ProvincialServiceImpl();

    @RequestMapping(value="/loadProvincial",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadAllProvincial(){
        List<Provincial> provincials = provincialService.queryAllProvincial();

        return JSONObject.toJSONString(provincials);

    }
}
