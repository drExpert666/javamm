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

package academy.devonline.javamm.vm;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import academy.devonline.javamm.code.fragment.ByteCode;
import academy.devonline.javamm.code.fragment.SourceCode;
import academy.devonline.javamm.compiler.Compiler;
import academy.devonline.javamm.compiler.CompilerConfigurator;
import academy.devonline.javamm.compiler.JavammSyntaxError;
import academy.devonline.javamm.interpreter.Interpreter;
import academy.devonline.javamm.interpreter.JavammRuntimeError;
import academy.devonline.javamm.interpreter.TerminateInterpreterException;
import academy.devonline.javamm.interpreter.component.InterpreterConfigurator;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */

public class VirtualMachineBuilder {

    /* protected методы, чтобы классы-наследники могли переопределять поведение данных методов */
    protected CompilerConfigurator buildCompilerConfigurator() {
        return new CompilerConfigurator();
    }

    protected InterpreterConfigurator buildInterpreterConfigurator() {
        return new InterpreterConfigurator();
    }

    public final VirtualMachine build() {
        return new VirtualMachineImpl(
            buildCompilerConfigurator().getCompiler(),
            buildInterpreterConfigurator().getInterpreter()
        );
    }

    public static final class VirtualMachineImpl implements VirtualMachine {

        private final Compiler compiler;

        private final Interpreter interpreter;

        public VirtualMachineImpl(final Compiler compiler, final Interpreter interpreter) {
            this.compiler = requireNonNull(compiler);
            this.interpreter = requireNonNull(interpreter);
        }

        @Override
        public void run(final SourceCode... sourceCodes)
            throws JavammSyntaxError, JavammRuntimeError, TerminateInterpreterException {
            final ByteCode byteCode = compiler.compile(sourceCodes);
            interpreter.interpret(byteCode);
        }
    }

}
