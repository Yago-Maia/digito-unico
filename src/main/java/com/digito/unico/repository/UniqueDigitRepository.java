package com.digito.unico.repository;

import com.digito.unico.domain.UniqueDigit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniqueDigitRepository extends JpaRepository<UniqueDigit, Long> {

    List<UniqueDigit> findAllByUserId(Long userId);
}
