package taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taco.pojo.Order;
import taco.utils.ResultBean;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/processOrder")
    public ResultBean<Object> processDesign(@RequestBody Order order) {
        log.info("process order: {}", order);
        return new ResultBean<>();
    }
}
