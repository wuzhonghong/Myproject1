package com.myweb.firsit.service;

import com.myweb.firsit.domain.Demo;
import com.myweb.firsit.domain.Ebook;
import com.myweb.firsit.mapper.DemoMapper;
import com.myweb.firsit.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;
    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
}
