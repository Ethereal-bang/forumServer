package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")
public class RooterController {

    RootService rootService;

    @Autowired
    public void setRootService(RootService rootService) {
        this.rootService = rootService;
    }

    @GetMapping("/data")
    public Res data() {
        return Res.ok().data("data", rootService.data());
    }

}