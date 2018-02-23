package com.xsr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 145811 on 2018/1/31.
 */
@RestController
@RequestMapping("/repo")
public class RepoController {

    @Autowired
    RepoService repoService;

    @RequestMapping("/moveSimple")
    public String moveSimple(){
        repoService.moveSimple();
        return "ok";
    }

    @RequestMapping("/move1st500")
    public String plus1st(){
        repoService.move1st500();
        return "ok";
    }

    @RequestMapping("/move2nd500")
    public String plus2nd(){
        repoService.move2nd500();
        return "ok";
    }

    @RequestMapping("/move3rd500")
    public String plus3rd50(){
        repoService.move3rd500();
        return "ok";
    }
}
