package com.milind.springbatchbillsetuptask;

import com.milind.springbatchbillsetuptask.domain.Bill;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
public class BillingConfigurationTest {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Test
    public void testJobResults() {
        List<Bill> billStatements = this.jdbcTemplate.query("select id, " +
                        "first_name, last_name, minutes, data_usage, bill_amount " +
                        "FROM bill_statements ORDER BY id",
                (rs, rowNum) -> new Bill(rs.getLong("id"),
                        rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
                        rs.getLong("DATA_USAGE"), rs.getLong("MINUTES"),
                        rs.getDouble("bill_amount")));

        assertThat(billStatements.size()).isEqualTo(5);
        Bill billStatement = billStatements.get(0);
        assertThat(billStatement.getBillAmount()).isEqualTo(6.0);
        assertThat(billStatement.getFirstName()).isEqualTo("jane");
        assertThat(billStatement.getLastName()).isEqualTo("doe");
        assertThat(billStatement.getId()).isEqualTo(1);
        assertThat(billStatement.getMins()).isEqualTo(500);
        assertThat(billStatement.getDataUsage()).isEqualTo(1000);

    }

}