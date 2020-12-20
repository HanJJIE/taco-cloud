package taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taco.exception.ParamException;
import taco.pojo.Order;
import taco.utils.ResultBean;
import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/processOrder")
    public ResultBean<Object> processDesign(@RequestBody @Valid Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ParamException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        log.info("process order: {}", order);
        return new ResultBean<>();
    }
}
