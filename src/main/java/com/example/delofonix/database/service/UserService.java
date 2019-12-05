package com.example.delofonix.database.service;

import com.example.delofonix.database.model.User;
import com.example.delofonix.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final String SQL = "SELECT UserId, Username, FirstName, LastName, Email, Phone FROM AppUsers";

    @Autowired
    JdbcTemplate usersJdbcTemplate;

    public List<User> findAll() {
        return usersJdbcTemplate.query(SQL, new UserRecordMapper());
    }

    public User findByUserId(String userId) {
        if (Utils.isNotEmptyValue(userId)) {
            String sql = SQL + " WHERE UserId = '" + userId.trim() + "'";
            return usersJdbcTemplate.queryForObject(sql, new UserRecordMapper());
        } else {
            return null;
        }
    }
    public void addUser(User user) {
        if (logger.isErrorEnabled())
            logger.debug("Adding user: " + user.getUserId());
        if (user != null && Utils.isNotEmptyValue(user.getUserId())) {
            String sql = "INSERT INTO AppUsers (UserId, Username, FirstName, LastName, Email, Phone) VALUES (" +
                    "'" + user.getUserId().trim() + "', " +
                    (Utils.isNotEmptyValue(user.getUsername()) ? "'" + user.getUsername().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(user.getFirstName()) ? "'" + user.getFirstName().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(user.getLastName()) ? "'" + user.getLastName().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(user.getEmail()) ? "'" + user.getEmail().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(user.getPhone()) ? "'" + user.getPhone().trim() + "', " : "NULL ") +
                    ")";
            if (logger.isDebugEnabled())
                logger.debug("addUser SQL: " + sql);
            usersJdbcTemplate.update(sql);
        }

    }

    public void updateUser(String setClause, String whereClause) {
        String sql = "UPDATE AppUsers SET " +
                setClause +
                " WHERE " + whereClause;
        if (logger.isDebugEnabled())
            logger.debug("updateUser SQL: " + sql);
        usersJdbcTemplate.update(sql);
    }


    public void updateUser(User user) {
        if (user != null && Utils.isNotEmptyValue(user.getUserId())) {
            String sql = "UPDATE AppUsers SET " +
                    "Username = " + "" + (Utils.isNotEmptyValue(user.getUsername()) ? "'" + user.getUsername().trim() + "', " : "NULL, ") +
                    "FirstName = " + (Utils.isNotEmptyValue(user.getFirstName()) ? "'" + user.getFirstName().trim() + "', " : "NULL, ") +
                    "LastName = " + (Utils.isNotEmptyValue(user.getLastName()) ? "'" + user.getLastName().trim() + "', " : "NULL, ") +
                    "Email = " + (Utils.isNotEmptyValue(user.getEmail()) ? "'" + user.getEmail().trim() + "', " : "NULL, ") +
                    "Phone = " + (Utils.isNotEmptyValue(user.getPhone()) ? "'" + user.getPhone().trim() + "', " : "NULL, ") +
                    "WHERE UserId = '" + user.getUserId().trim() + "'";
            if (logger.isDebugEnabled())
                logger.debug("updateUser SQL: " + sql);
            usersJdbcTemplate.update(sql);
        }
    }


    public void deleteByUserId(String userId) {
        if (Utils.isNotEmptyValue(userId)) {
            String sql = "DELETE FROM AppUsers WHERE UPPER(UserId) = '" + userId.toUpperCase() + "'";
            if (logger.isDebugEnabled())
                logger.debug("deleteByUserId SQL: " + sql);
            usersJdbcTemplate.update(sql);
        }

    }
    public UserDetails loadUserByUsername(String username){
        UserDetails userDetails;
        String sql = "SELECT  Username,  AccountNonExpired, AccountNonLocked, CredentialsNonExpired, Enabled FROM AppUsers WHERE Username='"+username+"'";
        if (logger.isDebugEnabled())
            logger.debug("loadUserByUsername SQL: " + sql);
        userDetails = usersJdbcTemplate.queryForObject(sql, new UserDetailsRecordMapper());
        return userDetails;
    }
    public Collection<GrantedAuthority> loadAuthoritiesByUsername(String username){

        String sql = "SELECT Authority FROM Authorities WHERE Username='"+username+"'";
        if (logger.isDebugEnabled())
            logger.debug("loadAuthoritiesByUsername SQL: " + sql);
        return usersJdbcTemplate.query(sql,new AuthoritiesRecordMapper());

        //return cga;
    }

    class UserRecordMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            if (Utils.isNotEmptyValue(resultSet.getString("UserId")))
                user.setUserId(resultSet.getString("UserId"));
            if (Utils.isNotEmptyValue(resultSet.getString("Username")))
                user.setUsername(resultSet.getString("Username"));
            if (Utils.isNotEmptyValue(resultSet.getString("FirstName")))
                user.setFirstName(resultSet.getString("FirstName"));
            if (Utils.isNotEmptyValue(resultSet.getString("LastName")))
                user.setLastName(resultSet.getString("LastName"));
            if (Utils.isNotEmptyValue(resultSet.getString("Email")))
                user.setEmail(resultSet.getString("Email"));
            if (Utils.isNotEmptyValue(resultSet.getString("Phone")))
                user.setPhone(resultSet.getString("Phone"));
            return user;
        }
    }
    class AuthoritiesRecordMapper implements RowMapper<GrantedAuthority> {
        @Override
        public GrantedAuthority mapRow(ResultSet resultSet, int i) throws SQLException {
            GrantedAuthority authority = new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    try {
                        return resultSet.getString("Authority");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };
            return authority;
        }
    }
    class UserDetailsRecordMapper implements RowMapper<UserDetails> {
        @Override
        public UserDetails mapRow(ResultSet resultSet, int i) throws SQLException {
            UserDetails userDetails = new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public String getUsername() {
                    try {
                        return resultSet.getString("Username");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                public boolean isAccountNonExpired() {
                    try {
                        return resultSet.getBoolean("AccountNonExpired");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return false;
                }

                @Override
                public boolean isAccountNonLocked() {
                    try {
                        return resultSet.getBoolean("AccountNonLocked");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return false;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    try {
                        return resultSet.getBoolean("CredentialsNonExpired");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    try {
                        return resultSet.getBoolean("Enabled");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            };
            return userDetails;
        }
    }

}
