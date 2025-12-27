package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

    @Autowired
    private MembershipTypeService membershipTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MembershipType createMembershipType(@RequestBody MembershipType membershipType) {
        return membershipTypeService.createMembershipType(membershipType);
    }

    @PutMapping("/{id}")
    public MembershipType updateMembershipType(@PathVariable Long id, @RequestBody MembershipType membershipType) {
        return membershipTypeService.updateMembershipType(id, membershipType);
    }

    @GetMapping
    public List<MembershipType> getAllMembershipTypes() {
        return membershipTypeService.getAllMembershipTypes();
    }

    @GetMapping("/{id}")
    public MembershipType getMembershipTypeById(@PathVariable Long id) {
        return membershipTypeService.getMembershipTypeById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getMembershipTypesByName(@PathVariable String name) {
        List<MembershipType> types = membershipTypeService.getMembershipTypesByName(name);
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
        }
        return ResponseEntity.ok(types);
    }

    @GetMapping("/price")
    public List<MembershipType> getMembershipTypesByPriceRange(@RequestParam double min, @RequestParam double max) {
        return membershipTypeService.getMembershipTypesByPriceRange(min, max);
    }

    @GetMapping("/price-less/{price}")
    public ResponseEntity<?> getMembershipTypesByPriceLessThan(@PathVariable double price) {
        List<MembershipType> types = membershipTypeService.getMembershipTypesByPriceLessThan(price);
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
        }
        return ResponseEntity.ok(types);
    }

    @GetMapping("/duration-greater/{duration}")
    public ResponseEntity<?> getMembershipTypesByDurationGreaterThan(@PathVariable int duration) {
        List<MembershipType> types = membershipTypeService.getMembershipTypesByDurationGreaterThan(duration);
        if (types.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found with duration greater than " + duration);
        }
        return ResponseEntity.ok(types);
    }
}
