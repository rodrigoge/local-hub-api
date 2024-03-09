package br.com.api.servicehub.core.entities;

public record ServiceTO(ServiceTypeEnum type, StateEnum state, String city) {
}
