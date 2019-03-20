package com.jk.mapper;

import com.jk.bean.VipInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VIPMapper {

    List<VipInfo> queryVIP();

    void deleteVIP(@Param("ids") String ids);

    void insertVIP(VipInfo vipInfo);
}
