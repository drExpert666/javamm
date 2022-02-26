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

package academy.devonline.javamm.compiler.component.impl.error;

import java.util.Objects;
import academy.devonline.javamm.code.fragment.SourceLine;
import academy.devonline.javamm.compiler.JavammSyntaxError;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class JavammLineSyntaxError extends JavammSyntaxError {

    public JavammLineSyntaxError(final String message, final SourceLine sourceLine) {
        super(String.format("Syntax error in '%s' [Line: %s]: %s",
            sourceLine.getModuleName(), sourceLine.getNumber(), Objects.requireNonNull(message)));
    }

}
