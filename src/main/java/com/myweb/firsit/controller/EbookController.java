package com.myweb.firsit.controller;

import com.myweb.firsit.domain.Demo;
import com.myweb.firsit.domain.Ebook;
import com.myweb.firsit.service.DemoService;
import com.myweb.firsit.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public List<Ebook> list(){
        return ebookService.list();
    }
    }
