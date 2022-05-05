package com.myweb.firsit.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.myweb.firsit.domain.Demo;
import com.myweb.firsit.domain.Ebook;
import com.myweb.firsit.domain.EbookExample;
import com.myweb.firsit.mapper.DemoMapper;
import com.myweb.firsit.mapper.EbookMapper;
import com.myweb.firsit.req.EbookReq;
import com.myweb.firsit.resp.EbookResp;
import com.myweb.firsit.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

//        List<EbookResp> respList =new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//           // EbookResp ebookResp = new EbookResp();
//            // BeanUtils.copyProperties(ebook,ebookResp);
        //对象复制

//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        return list;
    }
}
