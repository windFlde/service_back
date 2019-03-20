package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class BarSeries {
    String name;
    String type;
    List<String> data;
}
