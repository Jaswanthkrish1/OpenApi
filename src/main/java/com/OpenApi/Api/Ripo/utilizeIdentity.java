package com.OpenApi.Api.Ripo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OpenApi.Api.Entity.utilize_user;

public interface utilizeIdentity extends JpaRepository<utilize_user, Long> {
     public utilize_user findByEmail(String email);
     public utilize_user findByPassword(String password);
}
