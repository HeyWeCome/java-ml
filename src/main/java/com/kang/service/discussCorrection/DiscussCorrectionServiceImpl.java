package com.kang.service.discussCorrection;

import com.kang.dao.discussCorrection.DiscussCorrectionMapper;
import com.kang.dao.error.ErrorMapper;
import com.kang.pojo.DiscussCorrection;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/25 20:36
 * @version: 1.0
 */
@Service("DiscussCorrectionServiceImpl")
public class DiscussCorrectionServiceImpl implements DiscussCorrectionService {
    @Autowired
    private DiscussCorrectionMapper discussCorrectionMapper;

    public DiscussCorrectionMapper getDiscussCorrectionMapper(){
        return discussCorrectionMapper;
    }

    public void setDiscussCorrectionMapper(DiscussCorrectionMapper discussCorrectionMapper) {
        this.discussCorrectionMapper = discussCorrectionMapper;
    }

    // 用户新增投诉
    public int addDiscussCorrection(String discussId, String reporterId, String content) {
        String id = kangkang.id_get();
        DiscussCorrection discussCorrection = new DiscussCorrection(id,discussId,reporterId,content,"0");

        return discussCorrectionMapper.addDiscussCorrection(discussCorrection);
    }
}
