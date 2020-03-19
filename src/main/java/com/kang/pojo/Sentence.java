package com.kang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 名人名言
 * @author: HeyWeCome
 * @createDate: 2020/3/19 10:16
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sentence {
    String id;          // 句子的ID
    String content;     // 句子的内容
}
