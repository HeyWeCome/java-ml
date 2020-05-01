package com.kang.service.discussCorrection;

import com.kang.dao.discussCorrection.DiscussCorrectionMapper;
import com.kang.dao.error.ErrorMapper;
import com.kang.dao.questionDiscuss.QuestionDiscussMapper;
import com.kang.pojo.DiscussCorrection;
import com.kang.pojo.QuestionDiscuss;
import com.kang.service.questionDiscuss.QuestionDiscussServiceImpl;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
    @Autowired
    private QuestionDiscussServiceImpl questionDiscussService;

    public QuestionDiscussServiceImpl getQuestionDiscussService() {
        return questionDiscussService;
    }

    public void setQuestionDiscussService(QuestionDiscussServiceImpl questionDiscussService) {
        this.questionDiscussService = questionDiscussService;
    }

    public DiscussCorrectionMapper getDiscussCorrectionMapper(){
        return discussCorrectionMapper;
    }

    public void setDiscussCorrectionMapper(DiscussCorrectionMapper discussCorrectionMapper) {
        this.discussCorrectionMapper = discussCorrectionMapper;
    }

    // 查询所有的用户投诉讨论区
    public List<DiscussCorrection> loadAllCorrect() {
        return discussCorrectionMapper.loadAllCorrect();
    }

    // 用户新增投诉
    public int addDiscussCorrection(String discussId, String reporterId, String content) {
        String id = kangkang.id_get();
        DiscussCorrection discussCorrection = new DiscussCorrection(id,discussId,reporterId,content,"0");

        return discussCorrectionMapper.addDiscussCorrection(discussCorrection);
    }

    // 根据举报的留言来删除留言
    public int deleteDiscuss(String id) {
        System.out.println("要删除的举报id："+id);
        DiscussCorrection search = discussCorrectionMapper.search(id);

        // 获取到需要删除的留言ID
        String discussId = search.getDiscussId();

        System.out.println("discussId:"+discussId);


        return questionDiscussService.deleteQuestionDiscuss(discussId);
    }

    // 删除举报
    public int deleteReport(String id) {
        return discussCorrectionMapper.deleteReport(id);
    }

    // 将举报变成已处理
    public int modifyReport(String id) {
        return discussCorrectionMapper.modifyReport(id);
    }


    // 后台的加载所有举报
    public List<HashMap> loadAllReport() {
        return discussCorrectionMapper.loadAllReport();
    }
}
