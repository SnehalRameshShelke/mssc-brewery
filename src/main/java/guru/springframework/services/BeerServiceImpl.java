package guru.springframework.services;

import guru.springframework.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getUserById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("AAA")
                .beerStyle("BBB").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();

    }
}
