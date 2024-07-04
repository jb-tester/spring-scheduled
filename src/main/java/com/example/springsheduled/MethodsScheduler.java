package com.example.springsheduled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;


@Component
public class MethodsScheduler {

    public static final String METHOD_4 = "${cron.expr.method4}";
    private static final String METHOD_5 = "* * * * * *";

    @Value("${foo.bar.p1}") String a1;
    @Value("${foo.bar.p2}") String a2;
    @Value("${foo.bar.p3}") String a3;
    @Value("${cron.expr.method6}") String a4;

    @Scheduled(initialDelayString = "${foo.bar.p1}")
    public void foo(){
        
    }
    @Schedules(value = {
            @Scheduled(fixedDelayString = "${foo.bar.p1}"),
            @Scheduled(fixedRateString = "${foo.bar.p3}"),
            @Scheduled(cron = "@daily")
    })
    public void bar(){
        
    }

    @Schedules(value = {
            @Scheduled(cron = "-"),
            @Scheduled(cron = "0 0 9-17 * * MON-FRI"),
            @Scheduled(cron = "${foo.bar.p4}"),
            @Scheduled(cron = "@hourly"),
            @Scheduled(cron = "@midnight"),
            @Scheduled(cron = "${cron.expr.ref}")
    })
    public void crons(){

    }

    // property is defined in application.properties:
    @Scheduled(cron = "${cron.expr.method1}")
    public void method1() {
        System.out.println(" ---------- method1 -------------");
    }
    // property is not defined anywhere, use default:
    @Scheduled(cron = "${cron.expr.method2:* * * * * *}")
    public void method2() {
        System.out.println(" ---------- method2 -------------");
    }
    // property is defined in application.yaml, default can be ignored:
    @Scheduled(cron = "${cron.expr.method3:* * * * * *}")
    public void method3() {
        System.out.println(" ---------- method3 -------------");
    }
    // property is defined in application.yaml, placeholder extracted to constant
    @Scheduled(cron = METHOD_4)
    public void method4() {
        System.out.println(" ---------- method4 -------------");
    }

    // property is defined in yaml referencing another property from yaml
    @Scheduled(cron = "${cron.expr.method6}")
    public void method6() {
        System.out.println(" ---------- method6: " + a4 + " -------------");
    }

    // cron expression extracted to constant
    @Scheduled(cron = METHOD_5)
    public void method5() {
        System.out.println(" ---------- method5 -------------");
    }

}
