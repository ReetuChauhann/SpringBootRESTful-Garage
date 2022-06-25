package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Garage;
import com.reetu.dao.GarageRepo;

@Service
public class SGarage implements GarageService{
	  @Autowired
	  GarageRepo gr;

	@Override
	public String add(Garage g, MultipartFile image) {
		// TODO Auto-generated method stub
		return gr.add(g, image);
	}

	@Override
	public List<Garage> getall() {
		// TODO Auto-generated method stub
		return gr.getall();
	}

	@Override
	public Garage getbyid(int gid) {
		// TODO Auto-generated method stub
		return gr.getbyid(gid);
	}

	@Override
	public byte[] getphoto(int gid) {
		// TODO Auto-generated method stub
		return gr.getphoto(gid);
	}

	@Override
	public String delete(int gid) {
		// TODO Auto-generated method stub
		return gr.delete(gid);
	}

	@Override
	public List<Integer> getallids() {
		// TODO Auto-generated method stub
		return gr.getallids();
	}

	@Override
	public String updateimage(int gid, MultipartFile image) {
		// TODO Auto-generated method stub
		return gr.updateimage(gid, image);
	}

	@Override
	public String updategarage(Garage g) {
		// TODO Auto-generated method stub
		return gr.updategarage(g);
	}
	  
	  

}
