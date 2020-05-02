package com.kang.service.error;


import com.kang.pojo.ErrorCorrection;

import java.util.HashMap;
import java.util.List;

public interface ErrorService {
    List<ErrorCorrection> loadAllError();                                      // 加载所有的题目纠错
    List<HashMap> loadError();                                                  // 加载后台所需的题目纠错
    int addError(String questionId,String reportedId,String reason);          // 用户纠错题目
    int modifyStatus(String id,String status);                                 // 修改题目的状态
    int delete(String id);                                                      // 删除题目
}
