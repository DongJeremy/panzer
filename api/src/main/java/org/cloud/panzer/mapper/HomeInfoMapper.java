package org.cloud.panzer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cloud.panzer.domain.Goods;
import org.cloud.panzer.domain.HomeBanner;
import org.cloud.panzer.domain.HomeShortcut;

import java.util.List;

@Mapper
public interface HomeInfoMapper {
    List<HomeShortcut> selectAllShortcut();
    List<HomeBanner> selectAllBanner();
    List<Goods> selectAllGoods();
}
