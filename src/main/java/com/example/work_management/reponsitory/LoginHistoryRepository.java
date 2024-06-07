package com.example.work_management.reponsitory;

import com.example.work_management.entity.LoginHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    @Query(value = "select * from login_historys where (:username = '' or username like %:username%) and (:type = '' or type like %:type%)" +
            "and (:fromDate is null or created >= :fromDate) and (:toDate is null or created <= :toDate)",
            countQuery = "select count(*) from login_historys where (:username = '' or username like %:username%) and (:type = '' or type like %:type%) " +
                    "and (:fromDate is null or created >= :fromDate) and (:toDate is null or created <= :toDate)",
            nativeQuery = true)
    Page<LoginHistory> search(String username, String type, Long fromDate, Long toDate, Pageable pageable);
}
