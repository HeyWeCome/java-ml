package com.kang.service.provincial;

import com.kang.pojo.Provincial;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/13 15:11
 * @version: 1.0
 */
public interface ProvincialService {
    // 新增一个省份
    int addProvincial(Provincial provincial);

    // 通过id删除一个省份
    int deletProvincialById(int id);

    // 更新省份信息
    int updateProvincial(Provincial provincial);

    // 查询出所有的Provincial，返回list集合
    List<Provincial> queryAllProvincial();
}
