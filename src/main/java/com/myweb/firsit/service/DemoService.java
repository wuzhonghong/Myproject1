package com.myweb.firsit.service;

import com.myweb.firsit.domain.Demo;
import com.myweb.firsit.domain.Test;
import com.myweb.firsit.mapper.DemoMapper;
import com.myweb.firsit.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {
    @Resource
    private DemoMapper demoMapper;
    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }
}
