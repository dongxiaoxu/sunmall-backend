package site.dongxiaoxu.sunmall.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import site.dongxiaoxu.sunmall.system.EquipProductionCache;

@RestController
public class AsyncRequestController {

    @RequestMapping("/waitEquipProduce.mvc")
    public DeferredResult<String> waitEquipProduce(String equipCode) {
        DeferredResult<String> task = new DeferredResult<>(3000L, "failure");
        EquipProductionCache.addEquipTask(equipCode, task);
        return task;
    }
}
