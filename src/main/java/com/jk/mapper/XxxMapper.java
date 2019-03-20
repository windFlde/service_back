package com.jk.mapper;

import com.jk.bean.BlackUser;
import com.jk.bean.User;
import com.jk.bean.WenXian;
import com.jk.bean.WenZhang;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XxxMapper {


    void insertWenZhang(WenZhang wenZhang);

    void deleteWenZhang(@Param("ids") String ids);

    void updateWenZhang(WenZhang wenZhang);

    List<WenZhang> queryWenZhang(WenZhang w);

    List<WenXian> queryWenXian();

    void deleteWenXian(@Param("ids") String ids);

    void insertWenXian(WenXian wenZhang);

    WenZhang querySites(WenZhang wenZhang);

    Integer getSites(@Param("sites") Integer sites);

    void updateSitesByIntSites(@Param("intSites") Integer intSites, @Param("id") Integer id);

    void updateBeforeSites(@Param("intSites") Integer intSites, @Param("sites") Integer sites);

    Integer getDownSite(@Param("sites") Integer sites);

    WenZhang toTop(WenZhang wenZhang);

    Integer queryWenzSitesFt(Integer wenzSites);

    @Select("select min(sites) from t_wenzhang")
    Integer queryMinSites();

    void updateMinSites(@Param("minSites") Integer minSites, @Param("sites") Integer sites);

    void updateSitesByMinSites(@Param("minSites") Integer minSites, @Param("id") Integer id);


    @Select("select max(sites) from t_wenzhang")
    Integer queryMaxSites();

    void updateNowSites(@Param("maxSites") Integer maxSites, @Param("id") Integer id);

    @Select("select * from t_user_black")
    List<BlackUser> queryBlackUser();

    @Insert("insert into t_user_black (userId,name,loginacct) values(#{userId},#{name},#{loginacct})")
    void insertBlackUser(BlackUser blackUser);

    @Delete("delete from t_user_black where id in (  ${ids} )")
    void deleteBlackUser(@Param("ids") String ids);

    @Select("select * from t_user ")
    List<User> getUser();

    @Select("select count(id) from t_user_black  where userId =#{id}")
    Integer queryUserFt(Integer id);
}
