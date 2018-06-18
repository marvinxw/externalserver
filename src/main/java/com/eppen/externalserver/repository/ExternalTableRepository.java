package com.eppen.externalserver.repository;

import com.eppen.externalserver.models.ExternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface ExternalTableRepository extends JpaRepository<ExternalTable, Long> {

    // 查询comment like 的所有库信息
    @Query(nativeQuery = true, value = "select " +
            "id as id, " +
            "name as name, " +
            "created_by as createdBy, " +
            "updated_by as updatedBy, " +
            "created_at as createdAt, " +
            "updated_at as updatedAt, " +
            "del_flag as delFlag, " +
            "uuid as uuid " +
            "from eppen_external_server_table " +
            "where updated_at >= :timestamp limit 10000 " +
            " ")
    List<Map<String, Object>> getAllByUpdateTimeLimitn(@Param("timestamp") LocalDateTime timestamp);
}
