package com.malak.voyages.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malak.voyages.entities.Image;

public interface ImageRepository  extends JpaRepository<Image , Long>  {

}
