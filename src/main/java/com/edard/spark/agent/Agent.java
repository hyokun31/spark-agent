package com.edard.spark.agent;

import org.apache.spark.deploy.master.Master;
import org.apache.spark.deploy.master.WorkerInfo;
import scala.collection.mutable.HashSet;
import org.apache.spark.deploy.master.Converter;

import java.util.Iterator;

/**
 * Created by Park on 15. 1. 14..
 */
public class  Agent {
    private static Master sparkMaster;

    public static void start(Object[] args) {

        System.out.println("Run Java Agent");
        System.out.println(args.length);
        System.out.println(args[0].getClass().getName());

        sparkMaster = (Master) args[0];

        System.out.println(sparkMaster.masterUrl());

        HashSet<WorkerInfo> workerInfo = sparkMaster.workers();


        Iterator<WorkerInfo> itWokerInfo = Converter.convertWorkers(workerInfo).iterator();

        while (itWokerInfo.hasNext()) {
            WorkerInfo info = itWokerInfo.next();

            System.out.println(info.host());
        }
    }

    public static Master getMaster() {
        return sparkMaster;
    }
}
