package com.xhf.ssmForIDEA.dao;


import com.xhf.ssmForIDEA.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select name,pass,mail,usertype,useable from user where name=#{name} and pass=#{pass}")
    User FindUserByNamePass(@Param("name") String name, @Param("pass") String pass);
    //本来这里#号后面该是0,1，这样的位序，但是@Param("pass")注解改变了

    @Insert("insert into user (name,pass,mail,usertype,useable) values(#{name},#{pass},#{mail},#{usertype},#{useable})")
    int insertUser(User user);

    @Select("select count(*) from user where name=#{name}")
    int findUserByName(@Param("name") String name);


    @Select("select count(*) from miyues where miyue=#{miyue}")
    int findmiyue(@Param("miyue")String miyue);

    @Select("select count(*) from user where mail=#{mail}")
    int test_mailadress(@Param("mail")String mail);
}
