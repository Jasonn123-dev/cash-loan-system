package com.sevenseven.cashloansystem.service;

import java.util.List;
import java.util.Optional;

import com.sevenseven.cashloansystem.model.Teller;
import com.sevenseven.cashloansystem.repository.TellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TellerServiceImpl implements TellerService {

    @Autowired
    private TellerRepository tellerRepository;

    @Override
    public List<Teller> getAllTellers() {
        return tellerRepository.findAll();
    }

    @Override
    public void saveTeller(Teller teller) {
        this.tellerRepository.save(teller);
    }

    @Override
    public Teller getTellerById(long id) {
        Optional<Teller> optional = tellerRepository.findById(id);
        Teller teller = null;
        if (optional.isPresent()) {
            teller = optional.get();
        } else {
            throw new RuntimeException(" Teller not found for id :: " + id);
        }
        return teller;
    }

    @Override
    public void deleteTellerById(long id) {
        this.tellerRepository.deleteById(id);
    }

    @Override
    public Page<Teller> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.tellerRepository.findAll(pageable);
    }
}