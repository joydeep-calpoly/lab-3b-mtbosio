package lab_3c;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceTest {

    private Database mockDatabase;
    private Service service;

    @BeforeEach
    public void setUp() {
    	// mock db class
        mockDatabase = mock(Database.class);
        service = new Service(mockDatabase);
    }

    @Test
    public void testQueryDatabaseIsAvailable() {
        when(mockDatabase.isAvailable()).thenReturn(true);

        boolean result = service.query("SELECT * FROM table");

        assertTrue(result);
        verify(mockDatabase).isAvailable();
    }

    @Test
    public void testQueryDatabaseIsNotAvailable() {
        when(mockDatabase.isAvailable()).thenReturn(false);

        boolean result = service.query("SELECT * FROM table");

        assertFalse(result);
        verify(mockDatabase).isAvailable();
    }

    @Test
    public void testGetDatabaseID() {
        when(mockDatabase.getUniqueId()).thenReturn(42);

        String result = service.getDatabaseID();

        assertEquals("Using database with id: 42", result);
        verify(mockDatabase).getUniqueId();
    }
}
