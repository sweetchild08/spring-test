package com.example2.motor2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2.motor2.Model.Brand;
import com.example2.motor2.Repo.BrandRepository;
import com.example2.motor2.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    
    @Autowired
    private BrandRepository brandRepo;

    @GetMapping("/brands")
    public List<Brand> getbrands(){
        return brandRepo.findAll();
    }

    @GetMapping("/brand/{id}")
    ResponseEntity<Brand> getbrand(@PathVariable long id){
        Brand brand=brandRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Fetching failed"));
        return ResponseEntity.ok().body(brand);

    }

    @PostMapping("/brand")
    public String addBrand(@RequestBody Brand brand){
        brandRepo.save(brand);
        return "Saved..";
    }
    
    @PutMapping("/brand/{id}")
    ResponseEntity<Brand> updateBrand(@PathVariable long id,@RequestBody Brand brand){
        Brand updatedBrand=brandRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Updating Failed"));
        updatedBrand.setName(brand.getName());
        updatedBrand.setDescription(brand.getDescription());
        brandRepo.save(updatedBrand);
        return ResponseEntity.ok().body(updatedBrand);
    }

    @DeleteMapping("/brand/{id}")
    public String deleteBrand(@PathVariable long id){
        Brand brand=brandRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Deleting Failed"));
        brandRepo.delete(brand);
        return "deleted..";
    }

}
