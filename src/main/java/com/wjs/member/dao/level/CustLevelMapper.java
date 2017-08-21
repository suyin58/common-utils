package com.wjs.member.dao.level;

import com.wjs.member.model.level.CustLevel;
import com.wjs.member.model.level.CustLevelCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustLevelMapper {
    /**
     * cust_level数据表的操作方法: countByExample  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int countByExample(CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: deleteByExample  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int deleteByExample(CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cust_level数据表的操作方法: insert  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int insert(CustLevel record);

    /**
     * cust_level数据表的操作方法: insertSelective  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int insertSelective(CustLevel record);

    /**
     * cust_level数据表的操作方法: selectByExample  
     * 创建时间 : 2017-04-13 15:30:44
     */
    List<CustLevel> selectByExample(CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2017-04-13 15:30:44
     */
    CustLevel selectByPrimaryKey(Long id);

    /**
     * cust_level数据表的操作方法: lockByPrimaryKey  
     * 创建时间 : 2017-04-13 15:30:44
     */
    CustLevel lockByPrimaryKey(Long id);

    /**
     * cust_level数据表的操作方法: lockByExample  
     * 创建时间 : 2017-04-13 15:30:44
     */
    CustLevel lockByExample(CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 创建时间 : 2017-04-13 15:30:44
     */
    Long lastInsertId();

    /**
     * cust_level数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int updateByExampleSelective(@Param("record") CustLevel record, @Param("example") CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: updateByExample  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int updateByExample(@Param("record") CustLevel record, @Param("example") CustLevelCriteria example);

    /**
     * cust_level数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int updateByPrimaryKeySelective(CustLevel record);

    /**
     * cust_level数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2017-04-13 15:30:44
     */
    int updateByPrimaryKey(CustLevel record);
}