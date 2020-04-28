package com.kang.dao.error;

import com.kang.pojo.ErrorCorrection;

import java.util.List;

// 纠错报告类
public interface ErrorMapper {
    List<ErrorCorrection> loadAllError();               // 加载所有的题目纠错
    int addError(ErrorCorrection errorCorrection);
}
