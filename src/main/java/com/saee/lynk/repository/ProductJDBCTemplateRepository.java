package com.saee.lynk.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class ProductJDBCTemplateRepository {

    private  final JdbcTemplate jdbcTemplate;

    public ProductJDBCTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
