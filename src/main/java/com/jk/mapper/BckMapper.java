package com.jk.mapper;

import com.jk.bean.Example;
import com.jk.bean.Exprent;
import com.jk.bean.Sensitivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BckMapper {
    void updateEx(Integer id);

    void addEx(Example example);

    List<Example> queryEx();

    List<Exprent> quertAu();

    Example getEx(Integer id);

    void delEx(String ids);

    List<Sensitivity> querySs();

    void addSs(Sensitivity sensitivity);

    void delSs(Integer id);

    void updatePay(@Param("id")Integer id,@Param("pay")Integer pay);
}
