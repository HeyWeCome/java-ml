package com.kang.service.sentence;

import com.kang.dao.provincial.ProvincialMapper;
import com.kang.dao.sentence.SentenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/19 16:04
 * @version: 1.0
 */
@Service("SentenceServiceImpl")
public class SentenceServiceImpl implements SentenceService {
    // service调用dao层
    @Autowired
    private SentenceMapper sentenceMapper;

    public SentenceMapper getSentenceMapper(){
        return sentenceMapper;
    }

    public String loadOneSentence() {
        return sentenceMapper.loadOneSentence();
    }
}
