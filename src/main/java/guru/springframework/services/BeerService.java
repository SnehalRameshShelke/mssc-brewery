package guru.springframework.services;

import guru.springframework.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {

    BeerDto getUserById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);
}
