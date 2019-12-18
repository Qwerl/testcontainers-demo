package com.technokratos.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoTestcontainersTest {

    private static PostgreSQLContainer postgresContainer = new PostgreSQLContainer();
    private static PGSimpleDataSource dataSourcePostgres;

    @BeforeAll
    public static void setUpPostgres() {
        var start = LocalDateTime.now();
        postgresContainer.start();
        var end = LocalDateTime.now();
        System.out.println("UPTIME: " + start.until(end, ChronoUnit.SECONDS));
        dataSourcePostgres = new PGSimpleDataSource();
        dataSourcePostgres.setURL(postgresContainer.getJdbcUrl());
        dataSourcePostgres.setDatabaseName(postgresContainer.getDatabaseName());
        dataSourcePostgres.setUser(postgresContainer.getUsername());
        dataSourcePostgres.setPassword(postgresContainer.getPassword());
    }

    @Test
    public void checkPostgresConnection() throws SQLException {
        Connection connection = dataSourcePostgres.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 101;");
        resultSet.next();
        int anInt = resultSet.getInt(1);
        assertEquals(101, anInt);
    }

    @Test
    public void createSchemaPostgres() throws SQLException {
        Connection connection = dataSourcePostgres.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE SCHEMA demo;");
        statement.execute("CREATE TABLE demo.pepega (id integer)");
        statement.execute("INSERT INTO demo.pepega(id) values (1345);");
        ResultSet resultIds = statement.executeQuery("SELECT id FROM demo.pepega;");
        resultIds.next();
        int valueFromTable = resultIds.getInt(1);
        assertEquals(1345, valueFromTable);
    }

}
