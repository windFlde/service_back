package com.jk.service;

import com.jk.bean.ListData;

import java.util.List;

public interface BarChartsService {
    List<ListData> getEchart();

    List<ListData> getVIP();

    List<ListData> getWZData();

    List<ListData> getWXData();
}
