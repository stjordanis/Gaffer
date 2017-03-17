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

package uk.gov.gchq.gaffer.operation.impl.add;

import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.Options;
import uk.gov.gchq.gaffer.operation.Validatable;
import uk.gov.gchq.gaffer.operation.io.IterableInput;
import java.util.Map;

/**
 * An <code>AddElements</code> operation is a {@link uk.gov.gchq.gaffer.operation.Validatable} operation for adding elements.
 * This is a core operation that all stores should be able to handle.
 * This operation requires an {@link Iterable} of {@link uk.gov.gchq.gaffer.data.element.Element}s to be added. Handlers should
 * throw an {@link uk.gov.gchq.gaffer.operation.OperationException} if unsuccessful.
 * For normal operation handlers the operation {@link uk.gov.gchq.gaffer.data.elementdefinition.view.View} will be ignored.
 *
 * @see uk.gov.gchq.gaffer.operation.impl.add.AddElements.Builder
 */
public class AddElements implements
        Operation,
        Validatable,
        IterableInput<Element>,
        Options {
    private boolean validate = true;
    private boolean skipInvalidElements;
    private Iterable<Element> elements;
    private Map<String, String> options;

    @Override
    public boolean isValidate() {
        return validate;
    }

    @Override
    public void setValidate(final boolean validate) {
        this.validate = validate;
    }

    @Override
    public boolean isSkipInvalidElements() {
        return skipInvalidElements;
    }

    @Override
    public void setSkipInvalidElements(final boolean skipInvalidElements) {
        this.skipInvalidElements = skipInvalidElements;
    }

    @Override
    public Iterable<Element> getInput() {
        return elements;
    }

    @Override
    public void setInput(final Iterable<Element> elements) {
        this.elements = elements;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(final Map<String, String> options) {
        this.options = options;
    }

    public static class Builder extends Operation.BaseBuilder<AddElements, Builder>
            implements Validatable.Builder<AddElements, Builder>,
            IterableInput.Builder<AddElements, Element, Builder>,
            Options.Builder<AddElements, Builder> {
        public Builder() {
            super(new AddElements());
        }
    }
}
