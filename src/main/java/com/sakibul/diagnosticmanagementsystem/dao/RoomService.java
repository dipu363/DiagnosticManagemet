/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakibul.diagnosticmanagementsystem.dao;

import com.sakibul.diagnosticmanagementsystem.model.Room;
import org.springframework.stereotype.Service;

/**
 *
 * @author sakib
 */
@Service
public interface RoomService {

    public String insertRoom(Room cm);

    public String updateRoom(Room cm);

    public String deleteRoom(int id);

    public String viewRoom();

    public Room viewOneRoom(int id);

    public String viewAvailableRoom();
    
    public int viewAllRoom();

}
