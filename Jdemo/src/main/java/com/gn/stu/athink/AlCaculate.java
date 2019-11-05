package com.gn.stu.athink;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program mystu
 * @description: 小算法
 * @author: gaoning
 * @create: 2019/11/04 11:02
 */
public class AlCaculate {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,0};
        int b[] =reverse(a);
        for (int j=0;j<b.length;j++) {
            System.out.print(b[j]);
        }
    }
    //1
    public static int[]  reverse(int[] param){
        if(param==null){
            return null;
        }
        int[] res = new int[param.length];
        for (int i = 0; i < param.length; i++) {
            res[i] = param[param.length - i - 1];
        }
        return res;
    }

    static ExecutorService exePool = Executors.newFixedThreadPool(10);
    static PaymentRemoteSerivce paymentRemoteSerivce;
    //2
    public Map<String,ConsultResult> validPaymentType(List<String> paymentTypeList) throws InterruptedException {
        ConcurrentHashMap resMap = new ConcurrentHashMap(32);
        CountDownLatch countDownLatch = new CountDownLatch(paymentTypeList.size());
        for(String paymentType:paymentTypeList){
            exePool.execute(new PvThread(paymentType,countDownLatch,resMap));
        }
        countDownLatch.await();
        return resMap;
    }

    //3

}

class PaymentRemoteSerivce{
    public static ConsultResult isEnabled(String paymentType){
        return new ConsultResult();
    }
}

//假定支付方式可用性咨询接口统一为
//        ConsultResult PaymentRemoteSerivce.isEnabled(String paymentType);
//        返回结果
class ConsultResult {
    /** 咨询结果是否可用*/
    private boolean isEnable;
    /** 错误码 */
    private String errorCode;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
class PvThread implements Runnable {
    private String paymentType;
    private CountDownLatch countDownLatch;
    private Map resMap;
    PvThread(String paymentType, CountDownLatch  countDownLatch, Map resMap){
        this.paymentType = paymentType;
        this.countDownLatch = countDownLatch;
        this.resMap = resMap;
    }

    @Override
    public void run(){
        try{
            ConsultResult consultResult = PaymentRemoteSerivce.isEnabled(paymentType);
            if(consultResult.isEnable()==true){
                resMap.put(paymentType,consultResult);
            }
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }

}
