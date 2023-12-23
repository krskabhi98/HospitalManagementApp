package com.hospital.dao.impl.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AbstractHospitalManagementDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager hospitalEntityManager;

    public EntityManager getHospitalEntityManager() {
        return hospitalEntityManager;
    }

    public void setHospitalEntityManager(EntityManager hospitalEntityManager) {
        this.hospitalEntityManager = hospitalEntityManager;
    }
}
