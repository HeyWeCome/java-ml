package com.kang.service.discussCorrection;

import com.kang.pojo.DiscussCorrection;

public interface DiscussCorrectionService {
    int addDiscussCorrection(String discussId,String reporterId,String content);
}
