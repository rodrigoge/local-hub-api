package br.com.api.localhub.core.entities;

public record LocalResponse(String name, String address, LocalTypeEnum type, StateEnum state, String city) {
}
