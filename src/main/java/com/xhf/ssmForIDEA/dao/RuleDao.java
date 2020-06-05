package com.xhf.ssmForIDEA.dao;

import com.xhf.ssmForIDEA.pojo.ItemRule;
import com.xhf.ssmForIDEA.pojo.TimerRule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleDao {

    @Select("select rule from timer_rules where id=#{id}")
    String select_timer_rule_name_byid(@Param("id")String  id);//根据id查找timer的在文件中的名字

    @Select("select * from trigger_rules where id=#{id}")
    ItemRule select_itemrule_byid(@Param("id")String id);//根据id查item规则

    @Select("select * from timer_rules where id=#{id}")
    TimerRule select_timer_rule_byid(@Param("id")String id);//根据id查timer规则


    @Select("select * from trigger_rules ")
    List<ItemRule> select_all_itemrules();//获取所有item规则属性

    @Select("select * from timer_rules ")//获取所有timer规则属性
    List<TimerRule> select_all_timerrules();

    @Update("update timer_rules set useful = #{useful} where id =#{id}")
    int update_timer_rule_useful(@Param("id") String  id,@Param("useful")String  useful);//设置数据库timer规则可用性

    @Update("update trigger_rules set useful = #{useful} where id =#{id}")
    int update_item_rule_useful(@Param("id") String  id,@Param("useful")String  useful);//设置数据库item规则可用性

    @Update("update trigger_rules set rulename=#{rulename}," +
            "when_item_id=#{when_item_id}," +
            "when_device_name=#{when_device_name}," +
            "when_item_status=#{when_item_status}," +
            "then_item_id =#{then_item_id}," +
            "then_device_name=#{then_device_name}," +
            "then_item_status=#{then_item_status}," +
            "start_time=#{start_time},end_time=#{end_time},\n" +
            "file_content=#{file_content} WHERE id=#{id}")
    int update_itemrules(ItemRule itemRule);

    @Update("update timer_rules set rulename=#{rulename},\n" +
            "when_cron=#{when_cron},\n" +
            "then_item_id=#{then_item_id},\n" +
            "then_device_name=#{then_device_name},\n" +
            "then_item_status=#{then_item_status},\n" +
            "file_content=#{file_content} WHERE id=#{id}")
    int update_timerrules(TimerRule timerRule);


    @Insert("insert into timer_rules" +
            "(rule,rulename,when_cron,then_item_id,then_device_name,then_item_status, " +
            "file_content,useful) " +
            " values(#{rule},#{rulename},#{when_cron},#{then_item_id},#{then_device_name},#{then_item_status}," +
            "#{file_content},#{useful})")
    int addtotimer(TimerRule timerRule);

    @Insert("insert into trigger_rules" +
            "(rule,rulename,when_item_id,when_device_name,when_item_status," +
            "then_item_id,then_device_name,then_item_status," +
            "start_time,end_time,file_content,useful) " +
            "values(#{rule},#{rulename},#{when_item_id},#{when_device_name},#{when_item_status}," +
            "#{then_item_id},#{then_device_name},#{then_item_status}," +
            "#{start_time},#{end_time},#{file_content},#{useful})")
    int addtoitem(ItemRule itemRule);
    //这里应该有个存储过程，先行清除数据库表的数据，在设置自增id为1,再分批执行下方的插入
    //update注解可以执行alter

    @Insert("insert into item_by_thing (item_name,thing_name) values(#{item_name},#{thing_name})")
    int addto_itembything(@Param("item_name") String  item_name,@Param("thing_name")String  thing_name);

    @Delete("delete from trigger_rules where id =#{id}")
    int deleteitemrules(int id);

    @Delete("delete from timer_rules where id =#{id}")
    int deletetimerrules(int id);

}
