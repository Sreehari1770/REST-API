package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class third {
  private String FavColor="Red";
  @RequestMapping("/third")
  public String Color() {
	  return "My Favourite Color "+FavColor;
  }
}
