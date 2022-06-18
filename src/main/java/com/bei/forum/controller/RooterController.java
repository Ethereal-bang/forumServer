package com.bei.forum.controller;

import com.bei.forum.common.Res;
import com.bei.forum.pojo.DiscussArea;
import com.bei.forum.service.RootService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addArea") // 创建区块
    public Res addArea(@RequestParam String name, @RequestParam String url, @RequestParam String words) {
        if (rootService.addArea(name, url, words)) {
            return Res.ok().setMsg("区块创建成功");
        } else {
            return Res.err().setMsg("区块创建失败");
        }
    }

    @GetMapping("/area")
    public Res showArea() {
        return Res.ok().data("list", rootService.showAreas());
    }

    @GetMapping("/setArea")
    public Res setArea(@RequestParam DiscussArea discussArea) {
        if (rootService.setArea(discussArea)) {
            return Res.ok().setMsg("分区修改成功");
        } else {
            return Res.err().setMsg("分区修改失败");
        }
    }

    @GetMapping("/delArea")
    public Res delArea(@RequestParam int id) {
        if (rootService.delArea(id)) {
            return Res.ok().setMsg("分区删除成功");
        } else {
            return Res.err().setMsg("分区删除失败");
        }
    }

}
