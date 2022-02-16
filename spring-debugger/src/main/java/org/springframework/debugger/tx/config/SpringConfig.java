package org.springframework.debugger.tx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-04-06
 */
@Configuration
@ComponentScan("org.springframework.debugger.tx")
@Import({JdbcConfig.class, TransactionConfig.class})
@EnableTransactionManagement()
@PropertySource("classpath:tx/jdbc.properties")
public class SpringConfig {

}
