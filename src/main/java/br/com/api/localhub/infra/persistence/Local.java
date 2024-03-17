package br.com.api.localhub.infra.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.model.LocalTypeEnum;
import org.openapitools.model.StateEnum;

import java.util.UUID;

@Data
@Entity
@Table(name = "locals")
@NoArgsConstructor
@AllArgsConstructor
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LocalTypeEnum type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @Column(nullable = false)
    private String city;
}
