package site.dongxiaoxu.sunmall.system;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EquipProductionCache {

    private static Map<String, DeferredResult<String>> equipProductionInfo = new ConcurrentHashMap<>();


    public static DeferredResult<String> getEquipIsProducing(String equipCode) {
        return equipProductionInfo.get(equipCode);
    }

    public static void finishEquipProdcution(String equipCode) {
        equipProductionInfo.remove(equipCode);
    }

    public static void addEquipTask(String equipCode, DeferredResult<String> task) {
        equipProductionInfo.put(equipCode, task);
    }



}
