package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 纠错题目
 * @author: HeyWeCome
 * @createDate: 2020/3/17 10:00
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCorrection {
    String id;              // 纠错信息的ID
    String questionId;      // 试题的ID
    String reporterId;      // 纠错人的ID
    String reason;          // 原因
    String time;            // 纠错时间
    String status;          // 0未处理 1处理了
}
