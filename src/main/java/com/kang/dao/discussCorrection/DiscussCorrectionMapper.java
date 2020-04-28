package com.kang.dao.discussCorrection;

import com.kang.pojo.DiscussCorrection;

import java.util.List;

public interface DiscussCorrectionMapper {
    List<DiscussCorrection> loadAllCorrect();                           // 查询所有的投诉
    int addDiscussCorrection(DiscussCorrection discussCorrection);
}
