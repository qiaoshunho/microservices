package com.ouimeet.laravel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaravelApplicationTests {

	@Resource(name = "primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;


	@Test
	public void contextLoads() {
		String sql = "select * from admins";
		List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : list) {
			Set<Map.Entry<String, Object>> entries = map.entrySet( );
			if(entries != null) {
				Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
				while(iterator.hasNext( )) {
					Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
					Object key = entry.getKey( );
					Object value = entry.getValue();
					System.out.println(key+":"+value);
				}
			}
		}
	}

}
