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

package academy.devonline.javamm.interpreter.component.impl.operation;

import academy.devonline.javamm.code.fragment.Operation;
import academy.devonline.javamm.interpreter.TerminateInterpreterException;
import academy.devonline.javamm.interpreter.component.OperationInterpreter;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public abstract class AbstractOperationInterpreter<T extends Operation> implements OperationInterpreter<T> {

    @Override
    public void interpret(final T operation) {
        checkForTerminate();
        interpretOperation(operation);
    }


    private final void checkForTerminate() {
        if (Thread.interrupted()) {
            throw new TerminateInterpreterException();
        }
    }

    protected abstract void interpretOperation(T operation);
}
