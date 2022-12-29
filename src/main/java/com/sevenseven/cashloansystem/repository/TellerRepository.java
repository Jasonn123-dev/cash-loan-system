package com.sevenseven.cashloansystem.repository;

import com.sevenseven.cashloansystem.model.Teller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TellerRepository extends JpaRepository<Teller, Long>{

}