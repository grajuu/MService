/**
 * 
 */
package com.mgr.accounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * @author govind.raju
 *
 */
@ComponentScan
@Configuration
@EntityScan("com.mgr.accounts")
@EnableJpaRepositories("com.mgr.accounts")
@PropertySource("classpath:db-config.properties")
public class AccountsConfiguration {
	
	protected Logger logger;
	
	public AccountsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}
	
	/**
	 * in-memory "rewards" database populated with test data for testing
	 */
	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");
		
		DataSource dataSource =(new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();
		logger.info("dataSource = "+dataSource);
		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List< Map<String, Object>> accounts = jdbcTemplate.queryForList("SELECT number FROM T_ACCOUNT");
		logger.info("System has " + accounts.size() + " accounts");
		// populate with random balances
		
		Random random = new Random();
		
		for(Map<String, Object> items : accounts) {
			String number = (String) items.get("number");
			BigDecimal balance = new BigDecimal(random.nextInt(10000000) / 100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
			jdbcTemplate.update("UPDATE T_ACCOUNT SET balance = ? WHERE number = ?", balance, number);
		}
		
		return dataSource;
	}

}
