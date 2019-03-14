package com.jk.mapper;

import com.jk.bean.Example;
import com.jk.bean.Exprent;

import java.util.List;

public interface BckMapper {
    void updateEx(Integer id);

    void addEx(Example example);

    List<Example> queryEx();

    List<Exprent> quertAu();

    Example getEx(Integer id);

    void delEx(String ids);


}
