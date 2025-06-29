package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Creating mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Injecting mock into service
        MyService service = new MyService(mockApi);

        // calling method
        service.fetchData();

        // verifying interaction
        verify(mockApi).getData();  // verifies that getData() was called exactly once
    }
}

