package com.xhf.ssmForIDEA.dao;

import com.xhf.ssmForIDEA.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilDao {
    @Select("select max(id) from trigger_rules")
    int  get_maxid_fromitem();

    @Select("select max(id) from timer_rules")
    int get_maxid_fromtimer();

    @Select("select itemname from item_device where id =#{id}")
    String  get_itemname(@Param("id")int id);

    @Select("select COALESCE(MAX(id),0) from item_device")
    int get_maxid_fromitem_device();

    @Insert("insert  into  item_device (itemname,type,device) values (#{itemname},#{type},#{device})")
    int additem_device(Item item);
}
