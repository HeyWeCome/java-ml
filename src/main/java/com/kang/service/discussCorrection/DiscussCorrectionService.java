package com.kang.service.discussCorrection;

import com.kang.pojo.DiscussCorrection;

import java.util.List;

public interface DiscussCorrectionService {
    List<DiscussCorrection> loadAllCorrect();                           // 查询所有的投诉
    int addDiscussCorrection(String discussId,String reporterId,String content);
}
