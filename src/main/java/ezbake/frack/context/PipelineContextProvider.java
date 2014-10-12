/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

package ezbake.frack.context;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: eperry
 * Date: 12/4/13
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PipelineContextProvider {
    private static Map<Long, PipelineContext> contexts;

    static {
        contexts = Maps.newHashMap();
    }

    public synchronized static void add(PipelineContext context) {
        contexts.put(Thread.currentThread().getId(), context);
    }

    public static PipelineContext get() {
        return contexts.get(Thread.currentThread().getId());
    }
}
