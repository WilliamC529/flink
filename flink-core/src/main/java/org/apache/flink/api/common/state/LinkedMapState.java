/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.api.common.state;

import org.apache.flink.annotation.PublicEvolving;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

@PublicEvolving
public class LinkedMapState<UK, UV> implements MapState<UK, UV> {

    private final Map<UK, UV> map;

    public LinkedMapState() {
        this.map = new LinkedHashMap<>();
    }

    @Override
    public UV get(UK key) throws Exception {
        return map.get(key);
    }

    @Override
    public void put(UK key, UV value) throws Exception {
        map.put(key, value);
    }

    @Override
    public void putAll(Map<UK, UV> map) throws Exception {
        this.map.putAll(map);
    }

    @Override
    public void remove(UK key) throws Exception {
        map.remove(key);
    }

    @Override
    public boolean contains(UK key) throws Exception {
        return map.containsKey(key);
    }

    @Override
    public Iterable<Map.Entry<UK, UV>> entries() throws Exception {
        return map.entrySet();
    }

    @Override
    public Iterable<UK> keys() throws Exception {
        return map.keySet();
    }

    @Override
    public Iterable<UV> values() throws Exception {
        return map.values();
    }

    @Override
    public Iterator<Map.Entry<UK, UV>> iterator() throws Exception {
        return map.entrySet().iterator();
    }

    @Override
    public boolean isEmpty() throws Exception {
        return map.isEmpty();
    }
}