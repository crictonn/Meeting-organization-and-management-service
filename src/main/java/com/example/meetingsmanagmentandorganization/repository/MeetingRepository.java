package com.example.meetingsmanagmentandorganization.repository;

import com.example.meetingsmanagmentandorganization.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Optional<Meeting> findMeetingByName(String name);
    Meeting findMeetingById(Long id);
    ArrayList<Meeting> findMeetingByOwner(String owner);
    void deleteById(Long Id);

    Boolean existsMeetingByName(String name);
    Boolean existsMeetingById(Long id);
}
