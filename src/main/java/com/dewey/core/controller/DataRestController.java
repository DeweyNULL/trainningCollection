package com.dewey.core.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program springbootcachedemo
 * @description: 测试返回数据用
 * @author: xielinzhi
 * @create: 2019/06/30 12:06
 */

@RestController
public class DataRestController {

    @PostMapping("/test")
    public Map get(@RequestBody Map<String, Object> params){
        Map<String,Object> returnMap = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        List<Map> white = new ArrayList();
        Map<String,Object> whiteMap = new HashMap<>();
        whiteMap.put("matchType","精确完全匹配");
        whiteMap.put("matchFirstName","test1");
        whiteMap.put("matchMiddleName","test1");
        whiteMap.put("matchSurName", "test1");
        whiteMap.put("matchID","1");
        whiteMap.put("score","100");
        white.add(whiteMap);

        List<Map> black = new ArrayList();
        Map<String,Object> blackMap = new HashMap<>();
        blackMap.put("matchType","增加连字符");
        blackMap.put("matchFirstName","test1");
        blackMap.put("matchMiddleName","test1");
        blackMap.put("matchSurName", "test1");
        blackMap.put("matchID","2");
        blackMap.put("score","100");
        blackMap.put("blackType","Dow Jones");
        black.add(blackMap);
        result.put("origName","test1");
   //     result.put("white",white);
        result.put("black",black);
        List<Map> resultList = new ArrayList();
        resultList.add(result);
        returnMap.put("result",resultList);
        return returnMap;
    }
}
