package com.myweb.firsit.controller;

import com.myweb.firsit.req.CategoryQueryReq;
import com.myweb.firsit.req.CategorySaveReq;
import com.myweb.firsit.resp.CommonResp;
import com.myweb.firsit.resp.CategoryQueryResp;
import com.myweb.firsit.resp.PageResp;
import com.myweb.firsit.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public CommonResp all(CategoryQueryReq req){
        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>();
        List<CategoryQueryResp> list =categoryService.all(req);
        resp.setContent(list);
        return resp;
    }
    @GetMapping("/list")
    public CommonResp list(CategoryQueryReq req){
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> list =categoryService.list(req);
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody CategorySaveReq req){
        CommonResp resp = new CommonResp<>();
        categoryService.save(req);
        return resp;
    }
    }
