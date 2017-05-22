package com.lwk.spitter.data;

import com.lwk.spitter.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by lianjia on 2017-5-22.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbc;

    @Autowired //疑问：这里jdbc并没有配置成bean，它是怎么自动注入的？在DataConfig中配置了
    public JdbcSpitterRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Spitter save(Spitter spitter) {
        jdbc.update("insert into Spitter " +
                "(username,password,first_name,last_name,email) " +
                "values (?,?,?,?,?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }
}
