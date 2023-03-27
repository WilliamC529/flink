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

// import org.apache.flink.annotation.PublicEvolving;
// import org.apache.flink.runtime.state.AbstractStateBackend;

import java.util.Map;
import java.util.Iterator;

/**
 * {@link State} interface for partitioned key-value state. The key-value pair can be added, updated
 * and retrieved.Linked Hash Map version
 *
 * <p>The state is accessed and modified by user functions, and checkpointed consistently by the
 * system as part of the distributed snapshots.
 *
 * <p>The state is only accessible by functions applied on a {@code KeyedStream}. The key is
 * automatically supplied by the system, so the function always sees the value mapped to the key of
 * the current element. That way, the system can handle stream and state partitioning consistently
 * together.
 *
 * @param <UK> Type of the keys in the state.
 * @param <UV> Type of the values in the state.
 */
public interface LinkedMapState<UK, UV> extends State {

    /** SS
     */
    LinkedHashMap<UK, UV> getMap();

    /** SS
     */
    void put(UK key, UV value);

    /** SS
     */
    UV get(UK key);

    /** SS
     */
    void remove(UK key);

    /** SS
     */
    void clear();
}