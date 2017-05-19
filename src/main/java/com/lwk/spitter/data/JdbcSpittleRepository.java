package com.lwk.spitter.data;

import com.lwk.spitter.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lianjia on 2017-5-19.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private JdbcOperations jdbc;

    @Autowired //构造方法注入
    public JdbcSpittleRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query("select id,message,created_at,latitude,longitude" +
                "from Spittle" +
                "where id < ?" +
                "order by created_at desc limit ?",
                new SpittleRowMapper(), max, count);
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {
        @Override
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"));
        }
    }
}
