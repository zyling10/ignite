/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache.local;

import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.internal.processors.cache.distributed.GridCacheEventAbstractTest;
import org.apache.ignite.testframework.MvccFeatureChecker;
import org.junit.Before;

import static org.apache.ignite.cache.CacheMode.LOCAL;

/**
 * Tests events.
 */
public class GridCacheLocalEventSelfTest extends GridCacheEventAbstractTest {
    /** */
    @Before
    public void beforeGridCacheLocalEventSelfTest() {
        MvccFeatureChecker.skipIfNotSupported(MvccFeatureChecker.Feature.LOCAL_CACHE);
        MvccFeatureChecker.skipIfNotSupported(MvccFeatureChecker.Feature.CACHE_EVENTS);
    }

    /** {@inheritDoc} */
    @Override protected CacheConfiguration cacheConfiguration(String igniteInstanceName) throws Exception {
        MvccFeatureChecker.skipIfNotSupported(MvccFeatureChecker.Feature.LOCAL_CACHE);
        MvccFeatureChecker.skipIfNotSupported(MvccFeatureChecker.Feature.CACHE_EVENTS);

        return super.cacheConfiguration(igniteInstanceName);
    }

    /** {@inheritDoc} */
    @Override protected CacheMode cacheMode() {
        return LOCAL;
    }

    /** {@inheritDoc} */
    @Override protected int gridCount() {
        return 1;
    }
}
