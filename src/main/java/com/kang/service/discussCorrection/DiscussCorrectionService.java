package com.kang.service.discussCorrection;

import com.kang.pojo.DiscussCorrection;

import java.util.HashMap;
import java.util.List;

public interface DiscussCorrectionService {
    List<DiscussCorrection> loadAllCorrect();                           // 查询所有的投诉
    int addDiscussCorrection(String discussId,String reporterId,String content);
    int deleteDiscuss(String id);                                       // 根据举报的内容删除留言
    int deleteReport(String id);                                        // 删除举报
    int modifyReport(String id);                                        // 更改举报的状态
    List<HashMap> loadAllReport();                                      // 后台查询所有的投诉
}
