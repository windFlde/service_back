package com.jk.mapper;

import com.jk.bean.Advert;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface GgMapper {

    List<Advert> getData();

    void addData(Advert advert);

    @Delete("delete FROM t_advert where id = #{id}")
    void deleteItemsById(Integer id);
}
