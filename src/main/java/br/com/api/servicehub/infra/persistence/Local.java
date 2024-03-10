package br.com.api.servicehub.infra.persistence;

import br.com.api.servicehub.core.entities.LocalTypeEnum;
import br.com.api.servicehub.core.entities.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "services")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalTypeEnum type;

    @Column(nullable = false)
    private StateEnum state;

    @Column(nullable = false)
    private String city;
}
