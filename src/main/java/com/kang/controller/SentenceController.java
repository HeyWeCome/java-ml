package com.kang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kang.service.sentence.SentenceService;
import com.kang.service.sentence.SentenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/19 15:17
 * @version: 1.0
 */
@Controller
@RequestMapping("/sentence")
public class SentenceController {
    @Autowired
    private SentenceService sentenceService = new SentenceServiceImpl();

    @RequestMapping(value = "/loadSentence",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String loadSentence(){
        String sentence = sentenceService.loadOneSentence();
        return JSONObject.toJSONString(sentence);
    }
}
