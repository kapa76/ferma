/**
 * Copyright 2010 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.java;

import playn.java.JavaPlatform;

import org.junit.BeforeClass;
import org.junit.Ignore;

@Ignore("JUnit should ignore this by default, but it doesn't")
public abstract class AbstractPlayNTest {

  public static JavaPlatform plat;

  @BeforeClass public static void initializePlatform() {
    JavaPlatform.Config config = new JavaPlatform.Config();
    plat = new JavaPlatform.Headless(config);
  }
}
