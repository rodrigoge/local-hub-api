package br.com.api.servicehub.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalRepository extends JpaRepository<Local, UUID> {
}
