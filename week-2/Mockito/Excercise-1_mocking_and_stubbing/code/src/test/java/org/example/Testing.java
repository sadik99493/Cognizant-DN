package org.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class Testing {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assert result.equals("Mock Data") : "Expected 'Mock Data' but got " + result;
    }
}

