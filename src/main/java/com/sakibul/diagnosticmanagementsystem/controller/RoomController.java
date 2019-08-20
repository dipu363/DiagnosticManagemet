/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.controller;


import com.sakibul.diagnosticmanagementsystem.dao.RoomService;
import com.sakibul.diagnosticmanagementsystem.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sakib
 */
@Controller
public class RoomController {
     @Autowired
     RoomService rs;

    @RequestMapping("/addbed")
    public ModelAndView showroompage() {
        String roomgsonlist = rs.viewRoom();
        ModelAndView mv = new ModelAndView("admin/addbed", "addRoomObject1", new Room());
        mv.addObject("roommodelobject", roomgsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping("/bedlist")
    public ModelAndView showroompages() {
        String roomgsonlist = rs.viewRoom();
        ModelAndView mv = new ModelAndView("admin/roomlist", "addRoomObject1", new Room());
        mv.addObject("roommodelobject", roomgsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingroom", params = "Addroom")
    public String addroom(@ModelAttribute("addRoomObject1") Room cm) {
        
        rs.insertRoom(cm);
       
        return "redirect:/bedlist";
    }

    @RequestMapping(value = "/addingroom", params = "EditRoom")
    public String editRoom(@ModelAttribute("addRoomObject1") Room room) {

        
        rs.updateRoom(room);
        return "redirect:/bedlist";
    }

    @RequestMapping("removeroom/{Id}")
    public String removeroom(@PathVariable("Id") int roomId) {
        rs.deleteRoom(roomId);
        return "redirect:/bedlist";
    }

    @RequestMapping("/editroombutton")
    public ModelAndView passingoneroom(@RequestParam("getroomid") int roomid) {

        Room oneroom = rs.viewOneRoom(roomid);
        String roomgsonlist = rs.viewRoom();
        ModelAndView mv = new ModelAndView("admin/addbed", "addRoomObject1", oneroom);
        mv.addObject("roommodelobject", roomgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
