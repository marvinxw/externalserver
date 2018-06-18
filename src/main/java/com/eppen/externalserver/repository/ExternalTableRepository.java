package com.eppen.externalserver.repository;

import com.eppen.externalserver.models.ExternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalTableRepository extends JpaRepository<ExternalTable, Long> {
}
