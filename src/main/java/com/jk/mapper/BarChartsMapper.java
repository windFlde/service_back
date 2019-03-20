package com.jk.mapper;

import com.jk.bean.ListData;

import java.util.List;

public interface BarChartsMapper {
    List<ListData> getEchart();

    List<ListData> getVIPData();

    List<ListData> getWZData();

    List<ListData> getWXData();
}
