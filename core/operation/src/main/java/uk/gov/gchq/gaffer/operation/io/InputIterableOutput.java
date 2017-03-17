/*
 * Copyright 2016 Crown Copyright
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
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.operation.io;

import uk.gov.gchq.gaffer.operation.Operation;

public interface InputIterableOutput<I, O_ITEM> extends
        Input<I>,
        IterableOutput<O_ITEM> {

    interface Builder<OP extends InputIterableOutput<I, O_ITEM>, I, O_ITEM, B extends Builder<OP, I, O_ITEM, ?>>
            extends Operation.Builder<OP, B>,
            Input.Builder<OP, I, B>,
            IterableOutput.Builder<OP, O_ITEM, B> {
    }
}
