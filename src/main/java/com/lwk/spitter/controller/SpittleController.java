package com.lwk.spitter.controller;

import com.lwk.spitter.data.SpittleRepository;
import com.lwk.spitter.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by lianjia on 2017-5-19.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    //使用查询参数
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max",
                    defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count",
                    defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    //使用路径变量,这时候方法针对的就是动态的路径变量
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle (@PathVariable("spittleId") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }


}
