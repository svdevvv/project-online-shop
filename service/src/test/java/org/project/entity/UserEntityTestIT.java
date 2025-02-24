package org.project.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.project.base.EntityTestBaseIT;
import org.project.entity.classes.RoleEnum;
import org.project.entity.classes.UserEntity;


import java.time.LocalDate;

class UserEntityTestIT extends EntityTestBaseIT {

    @Test
    void createUser() {
        UserEntity userEntity = UserEntity.builder()
                .login("Kapucino")
                .firstName("Alex")
                .lastName("Kpucinov")
                .email("kpucino@gmail.com")
                .role(RoleEnum.ADMIN)
                .address("25, Vilnus")
                .password("12345")
                .birthday(LocalDate.of(2020,1,1))
                .build();

        session.beginTransaction();
        session.persist(userEntity);
        logger.info("Created user: {}", userEntity);
        session.getTransaction().commit();
    }

    @Test
    void getUser(){
        UserEntity userEntity = UserEntity.builder()
                .login("Kapucino")
                .firstName("Alex")
                .lastName("Kpucinov")
                .email("kpucino@gmail.com")
                .role(RoleEnum.ADMIN)
                .address("25, Vilnus")
                .password("12345")
                .birthday(LocalDate.of(2020,1,1))
                .build();
        UserEntity userEntity1 = UserEntity.builder()
                .login("Andreyka")
                .firstName("Andrey")
                .lastName("Kpucinov")
                .email("kpucino@gmail.com")
                .role(RoleEnum.ADMIN)
                .address("25, Vilnus")
                .password("12345")
                .birthday(LocalDate.of(2020,1,1))
                .build();
        session.beginTransaction();
        session.persist(userEntity);
        session.persist(userEntity1);
        session.getTransaction().commit();

        Assertions.assertEquals(userEntity,session.get(UserEntity.class,userEntity.getId()));
        logger.info("Get user: {}", userEntity);
    }
}