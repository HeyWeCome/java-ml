package com.kang.service.error;

import com.kang.dao.error.ErrorMapper;
import com.kang.dao.subject.SubjectMapper;
import com.kang.pojo.ErrorCorrection;
import com.kang.utils.kangkang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/4/23 14:57
 * @version: 1.0
 */

@Service("ErrorServiceImpl")
public class ErrorServiceImpl implements ErrorService {
    @Autowired
    private ErrorMapper errorMapper;

    public ErrorMapper getErrorMapper(){
        return errorMapper;
    }

    public void setErrorMapper(ErrorMapper errorMapper) {
        this.errorMapper = errorMapper;
    }

    // 加载所有的题目纠错
    public List<ErrorCorrection> loadAllError() {
        return errorMapper.loadAllError();
    }

    // 加载后台所需的纠错信息
    public List<HashMap> loadError() {
        return errorMapper.loadError();
    }

    public int addError(String questionId, String reportedId, String reason) {
        // 得到32位的uuid
        String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String createTime = kangkang.time_get();

        ErrorCorrection errorCorrection = new ErrorCorrection(id, questionId, reportedId, reason, createTime,"0");
        return errorMapper.addError(errorCorrection);
    }

    // 修改题目的错误信息
    public int modifyStatus(String id, String status) {
        return errorMapper.modifyStatus(id,status);
    }

    // 删除题目的举报
    public int delete(String id) {
        return errorMapper.delete(id);
    }
}
