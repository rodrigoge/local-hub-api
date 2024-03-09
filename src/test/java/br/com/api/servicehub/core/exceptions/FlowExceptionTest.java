package br.com.api.servicehub.core.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FlowExceptionTest {

    @Test
    void shouldReturnsGenericFlowException() {
        var localDateTime = LocalDateTime.of(2024, 1, 1, 1, 1);
        var flowException = new FlowException(
                HttpStatus.BAD_REQUEST,
                localDateTime,
                "Test error message during execution this method."
        );
        assertThat(flowException).isNotNull();
        assertThat(flowException.getHttpStatus()).isNotNull().isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(flowException.getDateTime()).isNotNull().isEqualTo(localDateTime);
        assertThat(flowException.getMessage()).isNotNull().isEqualTo("Test error message during execution this method.");
    }
}
