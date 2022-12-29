package com.sevenseven.cashloansystem.service;

import java.util.List;

import com.sevenseven.cashloansystem.model.Teller;
import org.springframework.data.domain.Page;



public interface TellerService {
    List<Teller> getAllTellers();
    void saveTeller(Teller teller);
    Teller getTellerById(long id);
    void deleteTellerById(long id);
    Page<Teller> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
