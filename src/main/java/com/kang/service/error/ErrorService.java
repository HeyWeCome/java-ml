package com.kang.service.error;


public interface ErrorService {
    int addError(String questionId,String reportedId,String reason);          // 用户纠错题目
}
