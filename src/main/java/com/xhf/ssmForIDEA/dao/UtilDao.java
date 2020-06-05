package com.xhf.ssmForIDEA.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilDao {
    @Select("select max(id) from trigger_rules")
    int  get_maxid_fromitem();

    @Select("select max(id) from timer_rules")
    int get_maxid_fromtimer();

    @Select("select item_name from item_by_thing where item_id =#{id}")
    String  get_itemname(@Param("id")int id);

}
