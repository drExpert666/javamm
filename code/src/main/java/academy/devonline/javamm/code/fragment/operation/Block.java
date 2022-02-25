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

package academy.devonline.javamm.code.fragment.operation;

import java.util.List;
import java.util.stream.Collectors;
import academy.devonline.javamm.code.fragment.Operation;
import academy.devonline.javamm.code.fragment.SourceLine;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class Block extends AbstractOperation implements Operation {

    private final List<Operation> operations;

    // если готовый список операций
    public Block(final List<Operation> operations, final SourceLine sourceLine) {
        super(sourceLine);
        this.operations = operations;
    }

    // если одна операция
    public Block(final Operation operation, final SourceLine sourceLine) {
        this(List.of(operation), sourceLine);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        /*
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Operation operation: operations) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(System.lineSeparator());
            }
            stringBuilder.append(operation.toString());
        }
        return stringBuilder.toString();
        */

        return operations.stream()
            // преобразуем  каждый элемент массива в стррковое представления
            .map(Object::toString)
            // линейный сепаратор - это символ, который используется в ОС для того чтобы определять
            // признак перехода на новую строку. Он не является константой и зависит от ОС, в которой выполняется код
            // (для Win - \r\n, Linux - \n, Mac - \n (в старой версии \r))
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
