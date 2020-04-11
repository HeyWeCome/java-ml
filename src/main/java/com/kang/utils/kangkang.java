package com.kang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 工具类
 * @author: HeyWeCome
 * @createDate: 2020/4/11 14:41
 * @version: 1.0
 */
public class kangkang {
    public static String time_get(){
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        return dt.format(new Date());
    }
}
