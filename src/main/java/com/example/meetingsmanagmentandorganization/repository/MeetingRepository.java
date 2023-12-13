package com.example.meetingsmanagmentandorganization.repository;

import com.example.meetingsmanagmentandorganization.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Optional<Meeting> findMeetingByName(String name);
    Boolean existsMeetingByName(String name);
    Boolean existsMeetingById(Long id);
}
