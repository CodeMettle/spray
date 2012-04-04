/*
 * Copyright (C) 2011 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cc.spray

import com.typesafe.config.{ConfigFactory, Config}
import collection.JavaConverters._


object SprayServletSettings {
  private[this] val c: Config = {
    val c = ConfigFactory.load()
    c.checkValid(ConfigFactory.defaultReference(), "spray.servlet")
    c.getConfig("spray.servlet")
  }

  val BootClasses       = c.getStringList  ("boot").asScala.toList
  val RootActorPath     = c getString       "root-actor-path"
  val TimeoutActorPath  = c getString       "timeout-actor-path"
  val RequestTimeout    = c getMilliseconds "request-timeout"
  val RootPath          = c getString       "root-path"

  require(RequestTimeout >= 0, "request-timeout must be >= 0")
}