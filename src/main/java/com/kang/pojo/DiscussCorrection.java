package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户举报评论
 * @author: HeyWeCome
 * @createDate: 2020/4/25 20:22
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussCorrection {
    String id;              // 纠错的固有ID
    String discussId;       // 留言的ID
    String reporterId;      // 举报人的ID
    String content;         // 举报的内容
    String status;          // 举报的状态，0：待处理， 1：已处理
}
