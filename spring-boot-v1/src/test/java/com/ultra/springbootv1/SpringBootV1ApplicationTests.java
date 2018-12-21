package com.ultra.springbootv1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootV1ApplicationTests {


    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Resource(name = "secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void primaryJdbcTemplateTest() {

        String sql = "SELECT * FROM duty.z_kt_user";

        List<Map<String, Object>> resObj = (List<Map<String, Object>>) jdbcTemplate1.execute(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement(sql);
            }
        }, new PreparedStatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.execute();
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    System.out.println("==" + rs.getString(1));
                    System.out.println("==" + rs.getString(2));
                    System.out.println("==" + rs.getString(3));
                    System.out.println("==" + rs.getString(4));
                    System.out.println("==" + rs.getString(5));
                }
                return null;
            }

        });
    }

    @Test
    public void secondaryJdbcTemplateTest() {
        String sql = " SELECT t.Extcredits2 total FROM pre_common_member_count t  "
                + " left join pre_common_member l on t.uid = l.uid "
                + " where l.username = 'Demo'";

        Map<String, Object> map = jdbcTemplate2.queryForMap(sql);
        if (map != null && map.size() > 0) {
            System.out.println("-------------------" + map.get("total"));
        }
    }

}

