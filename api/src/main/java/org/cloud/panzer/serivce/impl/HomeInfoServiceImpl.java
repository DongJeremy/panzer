package org.cloud.panzer.serivce.impl;

import org.cloud.panzer.mapper.HomeInfoMapper;
import org.cloud.panzer.domain.Goods;
import org.cloud.panzer.domain.HomeBanner;
import org.cloud.panzer.domain.HomeShortcut;
import org.cloud.panzer.serivce.HomeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeInfoServiceImpl implements HomeInfoService {

    @Resource
    HomeInfoMapper homeInfoMapper;

    @Override
    public List<HomeShortcut> selectAllShortcut() {
        return homeInfoMapper.selectAllShortcut();
    }

    @Override
    public List<HomeBanner> selectAllBanner() {
        return homeInfoMapper.selectAllBanner();
    }

    @Override
    public List<Goods> selectAllGoods() {
        return homeInfoMapper.selectAllGoods();
    }
}
