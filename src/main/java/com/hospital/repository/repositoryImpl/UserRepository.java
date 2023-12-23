package com.hospital.repository.repositoryImpl;


import com.hospital.dao.impl.jpa.AbstractHospitalManagementDAO;
import com.hospital.model.User;
import com.hospital.repository.IUserRepository;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class UserRepository extends AbstractHospitalManagementDAO implements IUserRepository {

    @Override
    public List<User> getAllUser() {
        TypedQuery query= (TypedQuery) getHospitalEntityManager().createNativeQuery("select * from Users");
        List<Object[]> userData=query.getResultList();
        return null;
    }

    @Override
    public User addNewUser(User newUser) {
        return null;
    }
}
