package micronaut.demo.app;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.micronaut.http.HttpStatus.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class MessageControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testMessage() {
        HttpResponse<String> resp = client.toBlocking().exchange(
                "/hello/Kostas",
                String.class
        );

        assertEquals(OK, resp.status());
        assertEquals("Hello Kostas", resp.body());
    }
}
