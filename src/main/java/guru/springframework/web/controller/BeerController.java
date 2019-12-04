package guru.springframework.web.controller;


import guru.springframework.services.BeerService;
import guru.springframework.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private  final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId")  UUID beerId)
    {
      return new ResponseEntity<>(beerService.getUserById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity hanlePost(BeerDto beerDto)
    {
     BeerDto savedDto=beerService.saveNewBeer(beerDto);
        HttpHeaders headers= new HttpHeaders();
        headers.add("location","/api/v1/beer/" +savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


}
