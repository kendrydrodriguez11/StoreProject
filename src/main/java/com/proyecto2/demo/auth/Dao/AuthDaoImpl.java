package com.proyecto2.demo.auth.Dao;

import com.proyecto2.demo.auth.AuthModels.UserModels;
import com.proyecto2.demo.auth.controllers.AuthResponse;
import com.proyecto2.demo.auth.controllers.request.LoginRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class AuthDaoImpl implements AuthDao {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public UserModels register(UserModels user) {
        try{
            return  entityManager.merge(user);
        }catch (Exception e){
            System.err.println("Error in authDao, in the register of auth in the database: " + e.getMessage());
            return null;
        }
    }



    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }



    @Override
    public UserModels finByName(String name) {
        try {
            String query = "select u from UserModels u where u.userName = :userName";
            return entityManager.createQuery(query, UserModels.class)
                    .setParameter("userName", name)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }


}
