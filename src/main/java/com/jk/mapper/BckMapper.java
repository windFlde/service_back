package com.jk.mapper;

import com.jk.bean.Example;
import com.jk.bean.Exprent;


import java.util.List;

public interface BckMapper {
    void updateEx();

    void addEx();

    List<Example> queryEx();

    List<Exprent> quertAu();
}