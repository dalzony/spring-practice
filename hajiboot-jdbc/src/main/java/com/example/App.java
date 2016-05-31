package com.example;

import com.example.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Hello world!
 *
 */

@EnableAutoConfiguration
@ComponentScan

public class App implements CommandLineRunner
{
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public void run(String... strings) throws Exception {
        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1);

        /*
        Customer result = jdbcTemplate.queryForObject(sql, param,
                new RowMapper<Customer>() {
                    @Override
                    public  Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Customer(rs.getInt("id"), rs.getString("first_name"),
                                rs.getString("last_name"));
                    }
                });
        */

        //람다 표현식을 사용해 RowMapper익명클래스 구현을 수정
        Customer result = jdbcTemplate.queryForObject(sql, param,
                (rs,rowNum) -> new Customer(rs.getInt("id"),
                        rs.getString("first_name"), rs.getString("last_name"))
        );
        System.out.println("result = " + result);

    }

    public static void main( String[] args ) {
        //System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
