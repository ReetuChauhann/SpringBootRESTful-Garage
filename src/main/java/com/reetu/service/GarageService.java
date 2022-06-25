package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Garage;

public interface GarageService {
	public String add(Garage g, MultipartFile image);
	public List<Garage> getall();
	public Garage getbyid(int gid);
	 public byte[] getphoto(int gid);
	 public String delete(int gid);
	 public List<Integer> getallids();
	 public String updateimage(int gid, MultipartFile image);
	 public String updategarage(Garage g);

}
