/*
 * Copyright (c) $today.year.devonline.academy
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
 *
 */

package academy.devonline.javamm.compiler.component.impl.operation.simple;

import java.util.ListIterator;
import java.util.Optional;
import academy.devonline.javamm.code.fragment.SourceLine;
import academy.devonline.javamm.code.fragment.operation.PrintlnOperation;
import academy.devonline.javamm.compiler.component.OperationReader;
import academy.devonline.javamm.compiler.component.impl.error.JavammLineSyntaxError;
import academy.devonline.javamm.compiler.component.impl.operation.AbstractOperationReader;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class PrintlnOperationReader extends AbstractOperationReader<PrintlnOperation>
    implements OperationReader {

    @Override
    protected Optional<String> getOperationKeyword() {
        return Optional.of("println");
    }

    @Override
    protected void validate(final SourceLine sourceLine) {
        if (!")".equals(sourceLine.getLast())) {
            throw new JavammLineSyntaxError("Expected ) at the end of line", sourceLine);
        }
        if (!"(".equals(sourceLine.getToken(1))) {
            throw new JavammLineSyntaxError("Expected ) after println", sourceLine);
        }
    }

    @Override
    protected PrintlnOperation get(final SourceLine sourceLine, final ListIterator<SourceLine> iterator) {
        final String text = sourceLine.getToken(2);
        return new PrintlnOperation(sourceLine, text);
    }
}
