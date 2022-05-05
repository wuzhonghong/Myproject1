package com.myweb.firsit.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.myweb.firsit.domain.Demo;
import com.myweb.firsit.domain.Ebook;
import com.myweb.firsit.domain.EbookExample;
import com.myweb.firsit.mapper.DemoMapper;
import com.myweb.firsit.mapper.EbookMapper;
import com.myweb.firsit.req.EbookReq;
import com.myweb.firsit.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;
    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList =new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);

        }
        return respList;
    }
}
