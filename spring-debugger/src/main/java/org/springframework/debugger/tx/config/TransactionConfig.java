package org.springframework.debugger.tx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Desc: 配置事务
 * @author: lizza1643@gmail.com
 * @date: 2020-04-06
 */
public class TransactionConfig {

    /**
     * 配置事务管理器
     * @author: lizza1643@gmail.com
     * @date: 2020/4/6 10:54 下午
     * @param dataSource
     * @return org.springframework.transaction.PlatformTransactionManager
     */
    @Bean("transactionManager")
    public PlatformTransactionManager createPlatformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
