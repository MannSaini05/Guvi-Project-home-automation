package main.java.com.yourpackage.dao;

public import com.yourpackage.dao.UserDAO;
import com.yourpackage.model.User;
import org.junit.jupiter.api.*;
import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserDAOTest {

    private UserDAO userDAO;
    private Connection mockConnection;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        userDAO = new UserDAO(mockConnection);
    }

    @Test
    public void testGetUserByIdSuccess() throws SQLException {
        int userId = 1;

        // Simulate the result set for the user
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement(anyString()).executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("username")).thenReturn("testuser");
        when(mockResultSet.getString("email")).thenReturn("test@example.com");

        User user = userDAO.getUserById(userId);

        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testGetUserByIdFailure() throws SQLException {
        int userId = 1;

        // Simulate the result set with no user found
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockConnection.prepareStatement(anyString()).executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        User user = userDAO.getUserById(userId);

        assertNull(user);  // User should be null since no user found
    }

    // Additional DAO tests...
}
 UserDAOTest {
    
}
