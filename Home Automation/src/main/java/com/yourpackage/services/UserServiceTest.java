import com.yourpackage.services.UserService;
import com.yourpackage.utils.DBConnection;
import org.junit.jupiter.api.*;
import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;
    private Connection mockConnection;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        userService = new UserService(mockConnection);
    }

    @Test
    public void testUserRegistrationSuccess() throws SQLException {
        String username = "testuser";
        String email = "test@example.com";

        // Simulate database operation success
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        boolean result = userService.registerUser(username, email);

        assertTrue(result);  // The registration should be successful
    }

    @Test
    public void testUserRegistrationFailure() throws SQLException {
        String username = "testuser";
        String email = "test@example.com";

        // Simulate database operation failure
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);

        boolean result = userService.registerUser(username, email);

        assertFalse(result);  // The registration should fail
    }

    // Other unit tests for the service layer can follow...
}

