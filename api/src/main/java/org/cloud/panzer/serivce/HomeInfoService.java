package org.cloud.panzer.serivce;

import org.cloud.panzer.domain.Goods;
import org.cloud.panzer.domain.HomeBanner;
import org.cloud.panzer.domain.HomeShortcut;

import java.util.List;

public interface HomeInfoService {
    List<HomeShortcut> selectAllShortcut();
    List<HomeBanner> selectAllBanner();
    List<Goods> selectAllGoods();
}
