package com.iit.web.Repository;


import com.iit.web.Dto.UserInfoForAccusedDto;
import com.iit.web.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepo
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

    }

    public User findByEmail(String email) {
        String sql = "SELECT id, email, password, first_name, last_name, " +
                "middle_name, year_level, college, department, role " +
                "FROM users WHERE email = ?";

        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
    }

    public List<UserInfoForAccusedDto> findByName(String query) {
        String sql = "SELECT id, (first_name || ' ' || last_name) AS full_name, department, role FROM users " +
                "WHERE (first_name || ' ' || last_name) ILIKE '%' || ? || '%'";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new UserInfoForAccusedDto(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("role"),
                        rs.getString("department")
                ),
                query
        );
    }







    //RowMapper implementation to map database columns to User object
    private static class UserRowMapper implements RowMapper<User>
    {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setMiddleName(rs.getString("middle_name"));
            user.setYearLevel(rs.getByte("year_level"));
            user.setCollege(rs.getString("college"));
            user.setDepartment(rs.getString("department"));
            user.setRole(rs.getString("role"));
            return user;
        }
    }
}
