package com.school.hotelmanagment.hotelmanag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

import com.school.hotelmanagment.model.Room;
import com.school.hotelmanagment.repository.RoomRepository;
import com.school.hotelmanagment.service.RoomService;

@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String getRoomsPage(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        System.out.printf("rooms: %s\n", rooms);
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @PostMapping("/rooms")
    public String addRoom(@Validated @NonNull @ModelAttribute Room room, BindingResult result) {
        if (result.hasErrors()) {
            return "rooms";
        }

        roomRepository.save(room);
        return "redirect:/rooms";
    }
}