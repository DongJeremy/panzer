package org.cloud.panzer.controller;

import org.cloud.panzer.domain.AndroidConfig;
import org.cloud.panzer.domain.BaseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/mobile")
public class AndroidController {

    // https://www.wpccw.com/mobile/index.php?act=index&op=get_android
    @GetMapping("/index.php")
    public BaseBean<AndroidConfig> getHomeInfo(@RequestParam("act") String act,
                                               @RequestParam("op") String op) {
        List<AndroidConfig.Item> list = Arrays.asList(
                new AndroidConfig.Item("android_advert_link", "https://www.wpccw.com/data/upload/ATTACH_MOBILE_AD/06068272708206445.png"),
                new AndroidConfig.Item("android_advert_url", "https://www.wpccw.com/wap/tmpl/product_dazhe.html"),
                new AndroidConfig.Item("android_apk_url", "http://192.168.1.200/assets/Panzer.apk"),
                new AndroidConfig.Item("android_app_version", "1.9"),
                new AndroidConfig.Item("android_update_content", "更新一波新内容啊~"),
                new AndroidConfig.Item("android_version_control", "1.7:1|1.8:1|1.9:1")
        );
        AndroidConfig androidConfig = new AndroidConfig(list);
        return new BaseBean<AndroidConfig>(200, androidConfig);
    }
}
