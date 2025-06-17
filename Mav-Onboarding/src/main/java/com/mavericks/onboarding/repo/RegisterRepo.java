package com.mavericks.onboarding.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericks.onboarding.entity.Register;

@Repository
public interface RegisterRepo extends JpaRepository <Register, String> {

}
