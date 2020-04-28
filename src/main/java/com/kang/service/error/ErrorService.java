package com.kang.service.error;


import com.kang.pojo.ErrorCorrection;

import java.util.List;

public interface ErrorService {
    List<ErrorCorrection> loadAllError();                                      // 加载所有的题目纠错
    int addError(String questionId,String reportedId,String reason);          // 用户纠错题目
}
