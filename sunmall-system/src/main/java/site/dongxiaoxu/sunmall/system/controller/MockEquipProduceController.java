package site.dongxiaoxu.sunmall.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import site.dongxiaoxu.sunmall.system.EquipProductionCache;

@RestController
public class MockEquipProduceController {

    @RequestMapping("/finishProduction.mvc")
    public String finishProduction(String equipCode) {
        DeferredResult<String> task = EquipProductionCache.getEquipIsProducing(equipCode);
        task.setResult(equipCode);
        EquipProductionCache.finishEquipProdcution(equipCode);
        return "success";
    }
}
