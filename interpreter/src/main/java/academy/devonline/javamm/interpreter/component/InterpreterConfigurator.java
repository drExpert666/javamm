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

package academy.devonline.javamm.interpreter.component;

import java.util.Set;
import academy.devonline.javamm.interpreter.Interpreter;
import academy.devonline.javamm.interpreter.component.impl.BlockOperationInterpreterImpl;
import academy.devonline.javamm.interpreter.component.impl.operation.InterpreterImpl;
import academy.devonline.javamm.interpreter.component.impl.operation.simple.PrintlnOperationInterpreter;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class InterpreterConfigurator {

    private Set<OperationInterpreter<?>> operationInterpreters = Set.of(new PrintlnOperationInterpreter());

    private BlockOperationInterpreter blockOperationInterpreter =
        new BlockOperationInterpreterImpl(operationInterpreters);

    private Interpreter interpreter = new InterpreterImpl(blockOperationInterpreter);

    public Interpreter getInterpreter() {
        return interpreter;
    }

}
