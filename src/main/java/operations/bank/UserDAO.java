package operations.bank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;
import java.util.Optional;

public class UserDAO {
    private final HikariDataSource dataSource;

    // Constructor: sets up connection pool
    public UserDAO(String url, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(10);  // Max 10 concurrent connections
        config.setMinimumIdle(2);       // Keep 2 connections warm

        this.dataSource = new HikariDataSource(config);
    }

    // INSERT new user
    public User insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, street_name, birth_day, birth_month, birth_year, id_number) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Bind data: ? gets replaced with actual values
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getStreetName());
            stmt.setInt(4, user.getBirthDay());
            stmt.setInt(5, user.getBirthMonth());
            stmt.setInt(6, user.getBirthYear());
            stmt.setLong(7, user.getIdNumber());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user.setId(rs.getLong("id"));
                    return user;
                }
            }
        }
        throw new SQLException("Failed to insert user");
    }

    // SELECT user by ID
    public Optional<User> getUserById(long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    // SELECT user by ID number
    public Optional<User> getUserByIdNumber(long idNumber) throws SQLException {
        String sql = "SELECT * FROM users WHERE id_number = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        }
        return Optional.empty();
    }

    // UPDATE user
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, street_name = ?, " +
                     "birth_day = ?, birth_month = ?, birth_year = ? WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getStreetName());
            stmt.setInt(4, user.getBirthDay());
            stmt.setInt(5, user.getBirthMonth());
            stmt.setInt(6, user.getBirthYear());
            stmt.setLong(7, user.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    // DELETE user
    public boolean deleteUser(long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    // Helper: convert ResultSet row to User object
    private User mapRow(ResultSet rs) throws SQLException {
        User user = new User(
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("street_name"),
            rs.getInt("birth_day"),
            rs.getInt("birth_month"),
            rs.getInt("birth_year"),
            rs.getLong("id_number")
        );
        user.setId(rs.getLong("id"));
        return user;
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
