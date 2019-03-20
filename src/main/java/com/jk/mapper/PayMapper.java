package com.jk.mapper;

import com.jk.bean.Pay;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PayMapper {

    List<Pay> getData();

    @Select("select p.*,e.em_title FROM `t_ example` e, t_pay p where e.id=p.emId and e.id=#{id}")
    Pay updateItem(Integer id);

    @Update("update t_pay set num =#{num},mony=#{mony} where id = #{id}")
    void addData(Pay pay);
}
