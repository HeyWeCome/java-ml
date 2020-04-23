package com.kang.dao.error;

import com.kang.pojo.ErrorCorrection;

// 纠错报告类
public interface ErrorMapper {
    int addError(ErrorCorrection errorCorrection);
}
