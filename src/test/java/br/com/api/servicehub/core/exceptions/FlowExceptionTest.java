package br.com.api.servicehub.core.exceptions;

import br.com.api.servicehub.mocks.MockBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FlowExceptionTest {

    @Test
    void should_ReturnGenericFlowException_When_InvalidInput() {
        var mockFlowException = MockBuilder.buildMockFlowException();
        var mockLocalDateTime = MockBuilder.buildMockLocalDateTime();
        assertThat(mockFlowException).isNotNull();
        assertThat(mockFlowException.getHttpStatus()).isNotNull().isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(mockFlowException.getDateTime()).isNotNull().isEqualTo(mockLocalDateTime);
        assertThat(mockFlowException.getMessage()).isNotNull().isEqualTo(
                "Error message encountered while executing this method test."
        );
    }
}
