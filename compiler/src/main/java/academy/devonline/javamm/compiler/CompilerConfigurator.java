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

package academy.devonline.javamm.compiler;

import java.util.Set;
import academy.devonline.javamm.compiler.component.BlockOperationReader;
import academy.devonline.javamm.compiler.component.OperationReader;
import academy.devonline.javamm.compiler.component.SourceLineReader;
import academy.devonline.javamm.compiler.component.TokenParser;
import academy.devonline.javamm.compiler.component.impl.BlockOperationReaderImpl;
import academy.devonline.javamm.compiler.component.impl.CompilerImpl;
import academy.devonline.javamm.compiler.component.impl.SourceLineReaderImpl;
import academy.devonline.javamm.compiler.component.impl.TokenParserImpl;
import academy.devonline.javamm.compiler.component.impl.operation.simple.PrintlnOperationReader;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
/* класс, объединяющий все отдельный компоненты воедино, находится в корне, чтобы был к нему доступ извне */
public class CompilerConfigurator {

    private TokenParser tokenParser = new TokenParserImpl();

    private SourceLineReader sourceLineReader = new SourceLineReaderImpl(tokenParser);

    private Set<OperationReader> operationReaders = Set.of(new PrintlnOperationReader());

    private BlockOperationReader blockOperationReader = new BlockOperationReaderImpl(operationReaders);

    private Compiler compiler = new CompilerImpl(sourceLineReader, blockOperationReader);

    public Compiler getCompiler() {
        return compiler;
    }

}
