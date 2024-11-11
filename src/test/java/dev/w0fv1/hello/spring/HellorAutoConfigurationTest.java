package dev.w0fv1.hello.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HellorAutoConfigurationTestApplication.class)
@ActiveProfiles("test")
public class HellorAutoConfigurationTest {

    @Autowired
    private Hellor hellor;

    @Test
    void contextLoads() {
        assertThat(hellor).isNotNull();
        hellor.say();
    }
}
