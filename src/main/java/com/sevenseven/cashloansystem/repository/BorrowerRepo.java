package com.sevenseven.cashloansystem.repository;

import com.sevenseven.cashloansystem.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepo extends JpaRepository<Borrower, Long> {
}
