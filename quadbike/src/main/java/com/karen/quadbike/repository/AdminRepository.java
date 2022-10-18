package com.karen.quadbike.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karen.quadbike.model.Admin;
import com.karen.quadbike.repository.crud.AdminCrudRepositoryInterfaz;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepositoryInterfaz adminCrudRepositoryInterfaz;

    public List<Admin> obtenerAdminCompleta() {
        return (List<Admin>) adminCrudRepositoryInterfaz.findAll();
    }

    public Optional<Admin> obtenerAdminId(Integer id) {
        return adminCrudRepositoryInterfaz.findById(id);
    }

    public Admin salvarAdmin(Admin admin) {
        return adminCrudRepositoryInterfaz.save(admin);
    }

    public void delete(Admin admin) {
        adminCrudRepositoryInterfaz.delete(admin);
    }
}
