package org.elpablo.beer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by thomap12 on 23/03/17.
 */
public class BeerRepository {

    public List<Beer> getBeers() {
        return Lists.newArrayList(new Beer(1, "Elvis Juice", 6), new Beer(2, "Punk IPA", 5.5));
    }

}
