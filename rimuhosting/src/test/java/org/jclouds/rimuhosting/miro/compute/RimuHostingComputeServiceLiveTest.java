/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
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
 * ====================================================================
 */
package org.jclouds.rimuhosting.miro.compute;

import static org.jclouds.compute.domain.OperatingSystem.JEOS;

import org.jclouds.compute.BaseComputeServiceLiveTest;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.TemplateBuilder;
import org.jclouds.ssh.jsch.config.JschSshClientModule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Ivan Meredith
 */
@Test(groups = "live", sequential = true, testName = "rimuhosting.RimuHostingNodeServiceLiveTest")
public class RimuHostingComputeServiceLiveTest extends BaseComputeServiceLiveTest {
   @BeforeClass
   @Override
   public void setServiceDefaults() {
      service = "rimuhosting";
   }

   protected Template buildTemplate(TemplateBuilder templateBuilder) {
      return templateBuilder.os(JEOS).osVersionMatches(".*9.04.*").smallest().build();
   }

   @Override
   protected JschSshClientModule getSshModule() {
      return new JschSshClientModule();
   }

}