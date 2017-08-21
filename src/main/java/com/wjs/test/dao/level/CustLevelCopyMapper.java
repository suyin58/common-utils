package com.wjs.test.dao.level;

import com.wjs.common.dao.PageDataList;
import com.wjs.test.model.level.CustLevelCopy;
import com.wjs.test.model.level.CustLevelCopyCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustLevelCopyMapper {
    /**
     * cust_level_copy数据表的操作方法: countByExample  
     * 
     */
    int countByExample(CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * cust_level_copy数据表的操作方法: insert  
     * 
     */
    int insert(CustLevelCopy record);

    /**
     * cust_level_copy数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(CustLevelCopy record);

    /**
     * cust_level_copy数据表的操作方法: selectByExample  
     * 
     */
    List<CustLevelCopy> selectByExample(CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: selectByPrimaryKey  
     * 
     */
    CustLevelCopy selectByPrimaryKey(Long id);

    /**
     * cust_level_copy数据表的操作方法: lockByPrimaryKey  
     * 
     */
    CustLevelCopy lockByPrimaryKey(Long id);

    /**
     * cust_level_copy数据表的操作方法: lockByExample  
     * 
     */
    CustLevelCopy lockByExample(CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<CustLevelCopy> pageByExample(CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * cust_level_copy数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") CustLevelCopy record, @Param("example") CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") CustLevelCopy record, @Param("example") CustLevelCopyCriteria example);

    /**
     * cust_level_copy数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(CustLevelCopy record);

    /**
     * cust_level_copy数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(CustLevelCopy record);
}