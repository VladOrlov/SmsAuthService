package com.digi.repository;

import com.digi.entity.db.PhoneAuthLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tymoshenkol on 26-Aug-16.
 */
@Repository
public interface PhoneAuthLogRepository extends JpaRepository<PhoneAuthLog, Integer> {
	PhoneAuthLog findByPhone (String phone);
}
