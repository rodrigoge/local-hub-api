package br.com.api.servicehub.core.entities;

public record LocalResponse(String name, String address, LocalTypeEnum type, StateEnum state, String city) {
}
