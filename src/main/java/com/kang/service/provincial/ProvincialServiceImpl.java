package com.kang.service.provincial;

import com.kang.dao.provincial.ProvincialMapper;
import com.kang.pojo.Provincial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/13 15:11
 * @version: 1.0
 */
@Service("ProvincialServiceImpl")
public class ProvincialServiceImpl implements ProvincialService{
    // service调用dao层
    @Autowired
    private ProvincialMapper provincialMapper;

    public ProvincialMapper getProvincialMapper(){
        return provincialMapper;
    }

    public void setProvincialMapper(ProvincialMapper provincialMapper) {
        this.provincialMapper = provincialMapper;
    }

    public int addProvincial(Provincial provincial) {
        return provincialMapper.addProvincial(provincial);
    }

    public int deletProvincialById(int id) {
        return provincialMapper.deletProvincialById(id);
    }

    public int updateProvincial(Provincial provincial) {
        return provincialMapper.updateProvincial(provincial);
    }

    public List<Provincial> queryAllProvincial() {
        return provincialMapper.queryAllProvincial();
    }


}
