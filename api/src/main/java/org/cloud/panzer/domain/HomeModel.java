package org.cloud.panzer.domain;

import java.util.List;

public class HomeModel {
    private List<HomeBanner> homeBannerList;
    private List<HomeShortcut> homeShortcutList;
    private List<Goods> goodsList;

    public HomeModel() {
    }

    public HomeModel(List<HomeBanner> homeBannerList, List<HomeShortcut> homeShortcutList, List<Goods> goodsList) {
        this.homeBannerList = homeBannerList;
        this.homeShortcutList = homeShortcutList;
        this.goodsList = goodsList;
    }

    public List<HomeBanner> getHomeBannerList() {
        return homeBannerList;
    }

    public void setHomeBannerList(List<HomeBanner> homeBannerList) {
        this.homeBannerList = homeBannerList;
    }

    public List<HomeShortcut> getHomeShortcutList() {
        return homeShortcutList;
    }

    public void setHomeShortcutList(List<HomeShortcut> homeShortcutList) {
        this.homeShortcutList = homeShortcutList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
