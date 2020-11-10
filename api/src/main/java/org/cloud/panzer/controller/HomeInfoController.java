package org.cloud.panzer.controller;

import org.cloud.panzer.domain.Goods;
import org.cloud.panzer.domain.HomeBanner;
import org.cloud.panzer.domain.HomeModel;
import org.cloud.panzer.domain.HomeShortcut;
import org.cloud.panzer.serivce.HomeInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeInfoController {

    @Resource
    HomeInfoService homeInfoService;

    @GetMapping("/v1/index")
    public ResultBean<HomeModel> getHomeInfo() {
        List<HomeShortcut> homeShortcuts = homeInfoService.selectAllShortcut();
        List<Goods> goods = homeInfoService.selectAllGoods();
        List<HomeBanner> homeBanners = homeInfoService.selectAllBanner();
        return new ResultBean<>(200, new HomeModel(homeBanners, homeShortcuts, goods));
    }

}
