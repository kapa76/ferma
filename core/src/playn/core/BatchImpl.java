/**
 * Copyright 2012 The PlayN Authors
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
package playn.core;

import java.util.HashMap;
import java.util.Map;

public class BatchImpl implements Storage.Batch {

  protected final Storage storage;
  private Map<String,String> updates = new HashMap<String,String>();

  public BatchImpl (Storage storage) {
    this.storage = storage;
  }

  public void setItem(String key, String data) {
    updates.put(key, data);
  }

  public void removeItem(String key) {
    updates.put(key, null);
  }

  public void commit() {
    try {
      onBeforeCommit();
      for (Map.Entry<String,String> entry : updates.entrySet()) {
        String key = entry.getKey(), data = entry.getValue();
        if (data == null)
          removeImpl(key);
        else
          setImpl(key, data);
      }
      onAfterCommit();

    } finally {
      updates = null; // prevent further use
    }
  }

  protected void onBeforeCommit() {
  }

  protected void setImpl(String key, String data) {
    storage.setItem(key, data);
  }

  protected void removeImpl(String key) {
    storage.removeItem(key);
  }

  protected void onAfterCommit() {
  }
}
