package com.myweb.firsit.controller;

import com.myweb.firsit.req.DocQueryReq;
import com.myweb.firsit.req.DocSaveReq;
import com.myweb.firsit.resp.DocQueryResp;
import com.myweb.firsit.resp.CommonResp;
import com.myweb.firsit.resp.PageResp;
import com.myweb.firsit.service.DocService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Resource
    private DocService docService;

    @GetMapping("/all")
    public CommonResp all(DocQueryReq req){
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list =docService.all(req);
        resp.setContent(list);
        return resp;
    }
    @GetMapping("/list")
    public CommonResp list(DocQueryReq req){
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        PageResp<DocQueryResp> list =docService.list(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody DocSaveReq req){
        CommonResp resp = new CommonResp<>();
        docService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));
        docService.delete(list);
        return resp;
    }
    }
