package com.xhf.ssmForIDEA.dao;



import com.xhf.ssmForIDEA.pojo.User_admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {

    @Update("update user set useable = #{useable} where id =#{id}")
    int changeUser_useable(@Param("id")int id,@Param("useable")int useable);


    //ORDER BY commitTime DESC语句更改为ORDER BY MAX(commitTime) DESC,报错就试一下
    @Select("select id,name,useable from user where usertype !=1 ORDER  BY useable")
    List<User_admin> getusers();
}
