package com.xhf.ssmForIDEA.dao;


import com.xhf.ssmForIDEA.pojo.Miyue;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiyueDao {

    @Select("select id,miyue from miyues")
    List<Miyue> get_miyues();

    @Insert("insert into miyues (miyue) values(#{miyue}) ")
    int addmiyue(@Param("miyue") String miyue);

    @Update("update miyues set miyue = #{miyue} where id =#{id}")
    int updatemiyue(@Param("id") int id,@Param("miyue") String miyue);

    @Delete("delete from miyues where id =#{id}")
    int deletemiyue(@Param("id") int id);


}
