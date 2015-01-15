package org.apache.spark.deploy.master

/**
 * Created by Park on 15. 1. 15..
 */
import java.util

import org.apache.spark.deploy.master.{WorkerInfo}
import scala.collection.JavaConverters._
import scala.collection.mutable.HashSet


object Converter {
  def convertWorkers(workerInfo: HashSet[WorkerInfo]):util.Set[WorkerInfo] = {
    return workerInfo.toSet.asJava;
  }
}