package com.myweb.firsit.controller;

import com.myweb.firsit.req.EbookQueryReq;
import com.myweb.firsit.req.EbookSaveReq;
import com.myweb.firsit.resp.CommonResp;
import com.myweb.firsit.resp.EbookQueryResp;
import com.myweb.firsit.resp.PageResp;
import com.myweb.firsit.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list =ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }
    }
