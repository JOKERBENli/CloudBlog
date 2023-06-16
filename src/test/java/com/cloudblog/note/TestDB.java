package com.cloudblog.note;

import com.cloudblog.note.util.DBUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDB {
    //使用日志工厂类，记录日志
    private Logger logger = LoggerFactory.getLogger(TestDB.class);


    /**
     * 单元测试方法
     * */
    @Test
    public void testDB(){
        System.out.println(DBUtil.getConnect());

        //使用日志
        logger.info("获取数据库连接："+DBUtil.getConnect());
        logger.info("获取数据库连接：{}"+DBUtil.getConnect());
    }
}
