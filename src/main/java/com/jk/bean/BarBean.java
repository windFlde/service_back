package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class BarBean {
    String text;
    String subtext;
    List<String> xaxisData;
    List<BarSeries> series;
}
