package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.MembershipType;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {

    @Query("SELECT m FROM MembershipType m WHERE m.typeName = :name")
    List<MembershipType> findByTypeName(@Param("name") String name);

    List<MembershipType> findByPriceBetween(double min, double max);

    List<MembershipType> findByPriceLessThan(double price);

    List<MembershipType> findByDurationInMonthsGreaterThan(int duration);
}

