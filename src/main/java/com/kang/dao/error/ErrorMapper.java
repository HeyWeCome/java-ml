package com.kang.dao.error;

import com.kang.pojo.ErrorCorrection;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

// 纠错报告类
public interface ErrorMapper {
    List<ErrorCorrection> loadAllError();               // 加载所有的题目纠错
    List<HashMap> loadError();                          // 加载后台所需的题目纠错
    int modifyStatus(@Param("id") String id,@Param("status") String status);                        // 修改题目的状态
    int delete(String id);                              // 删除题目
    int addError(ErrorCorrection errorCorrection);
}
