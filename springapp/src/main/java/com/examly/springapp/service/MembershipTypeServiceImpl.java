package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    @Override
    public MembershipType createMembershipType(MembershipType membershipType) {
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public MembershipType updateMembershipType(Long id, MembershipType membershipType) {
        membershipType.setTypeId(id);
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public List<MembershipType> getAllMembershipTypes() {
        return membershipTypeRepository.findAll();
    }

    @Override
    public MembershipType getMembershipTypeById(Long id) {
        return membershipTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<MembershipType> getMembershipTypesByName(String name) {
        return membershipTypeRepository.findByTypeName(name);
    }

    @Override
    public List<MembershipType> getMembershipTypesByPriceRange(double min, double max) {
        return membershipTypeRepository.findByPriceBetween(min, max);
    }

    @Override
    public List<MembershipType> getMembershipTypesByPriceLessThan(double price) {
        return membershipTypeRepository.findByPriceLessThan(price);
    }

    @Override
    public List<MembershipType> getMembershipTypesByDurationGreaterThan(int duration) {
        return membershipTypeRepository.findByDurationInMonthsGreaterThan(duration);
    }
}