package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 举报信息类
 * @author: HeyWeCome
 * @createDate: 2020/3/17 9:53
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    String id;                      // 举报ID
    String questionDiscussId;       // 讨论试题的ID
    String reporter;                // 举报人的ID
    String informee;                // 被举报人的ID
    Integer reportType;             // 举报类型
    String description;             // 说明
    String time;                    // 举报时间

    /*
    * 举报类型：
    * 1：广告及垃圾信息
    * 2：抄袭或涉嫌侵权
    * 3：不友善/色情/低俗
    * 4：政治敏感
    * 5：其他
    * */
}
