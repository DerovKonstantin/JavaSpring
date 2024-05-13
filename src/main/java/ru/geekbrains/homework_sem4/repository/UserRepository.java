package ru.geekbrains.homework_sem4.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ru.geekbrains.homework_sem4.model.User;

@Repository // перехоит по управление
public class UserRepository {

    private final JdbcTemplate jdbc;
    

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public void save(String userFirstName, String userLastName) {////////////////////////////////////////////////
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, userFirstName, userLastName);
        // return  user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, Integer.toString(id));

    }

    public void updateUser(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }

    public User getOne(int id) {
        String sql = "SELECT * FROM userTable WHERE id = " + id;
        RowMapper<User> userRowMapper = ((rs, rowMum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });
        List<User> users = jdbc.query(sql, userRowMapper);
        if (users.isEmpty()) {
            return null;
        } else {
            return jdbc.query(sql, userRowMapper).get(0);
        }
    }

}
