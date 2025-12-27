package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.MembershipType;

public interface MembershipTypeService {
    MembershipType createMembershipType(MembershipType membershipType);
    MembershipType updateMembershipType(Long id, MembershipType membershipType);
    List<MembershipType> getAllMembershipTypes();
    MembershipType getMembershipTypeById(Long id);
    List<MembershipType> getMembershipTypesByName(String name);
    List<MembershipType> getMembershipTypesByPriceRange(double min, double max);
    List<MembershipType> getMembershipTypesByPriceLessThan(double price);
    List<MembershipType> getMembershipTypesByDurationGreaterThan(int duration);
}