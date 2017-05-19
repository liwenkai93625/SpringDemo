package com.lwk.spitter.data;

import com.lwk.spitter.model.Spittle;

import java.util.List;

/**
 * Created by lianjia on 2017-5-18.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
