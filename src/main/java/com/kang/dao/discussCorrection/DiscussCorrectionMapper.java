package com.kang.dao.discussCorrection;

import com.kang.pojo.DiscussCorrection;

import java.util.HashMap;
import java.util.List;

public interface DiscussCorrectionMapper {
    List<DiscussCorrection> loadAllCorrect();                           // 查询所有的投诉
    List<HashMap> loadAllReport();                                      // 后台查询所有的投诉
    int deleteReport(String id);                                        // 删除举报
    int modifyReport(String id);                                        // 更改举报的状态
    DiscussCorrection search(String id);                                // 根据举报的ID来查询举报
    int deleteQuestionDiscuss(String id);                               // 删除举报对应的回答
    int addDiscussCorrection(DiscussCorrection discussCorrection);
}
