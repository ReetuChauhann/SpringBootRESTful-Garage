package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Garage;
import com.reetu.dao.GarageRepo;
import com.reetu.service.GarageService;

@RestController
public class Controller {
	
	@Autowired
	GarageService Gs;
	
	@RequestMapping("/")
	public String page() {
		return "welcome honey";
	}
	
	
	@PostMapping("/add")
		public ResponseEntity<String> add(@RequestPart("Garage") Garage g, @RequestPart("image") MultipartFile image){
		
		String r=Gs.add(g, image);
		if(r.equals("success")) {
			return new ResponseEntity<>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(r,HttpStatus.NOT_MODIFIED);
		}
			
		}
	
	@GetMapping("/getallgarage")
	public List<Garage> getall(){
		List<Garage> g=Gs.getall();
		return g;
	}
	
	@GetMapping("/getbyid/{gid}")
	public Garage getbyid(@PathVariable("gid") int gid) {
		Garage g=Gs.getbyid(gid);
		return g;
	}
	
	@DeleteMapping("/deletebyid/{gid}")
	public ResponseEntity<String> deletebyid(@PathVariable("gid") int gid){
		String r=Gs.delete(gid);
		if(r.equals("success")) {
			return new ResponseEntity<>(r,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(r, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@GetMapping("/getallids")
	public List<Integer> getallids(){
		List<Integer> ids=Gs.getallids();
		return ids;
	}
	
	@PutMapping("/updategarage")
	public String update(@RequestBody Garage g) {
		String r=Gs.updategarage(g);
		return r;
		
	}
	
	@PutMapping("/updateimage/{gid}")
	public String updateimage(@PathVariable("gid") int gid, @RequestPart("image") MultipartFile image) {
		String r=Gs.updateimage(gid, image);
		return r;
	}

}
