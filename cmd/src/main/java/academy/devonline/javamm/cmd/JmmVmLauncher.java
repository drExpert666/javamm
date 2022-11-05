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

package academy.devonline.javamm.cmd;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import academy.devonline.javamm.code.fragment.ByteCode;
import academy.devonline.javamm.code.fragment.SourceCode;
import academy.devonline.javamm.compiler.Compiler;
import academy.devonline.javamm.compiler.CompilerConfigurator;

/**
 * @author drExpert666
 */
public class JmmVmLauncher {

    public static void main(String[] args) {

        final List<Integer> integers = List.of(15, 2, 3, 48, 5);
        final Integer reduce = integers.stream().reduce((a, b) -> a > b ? a : b).orElse(-666);
        System.out.println(reduce);

        final ListIterator<Integer> listIterator = integers.listIterator();

        while (listIterator.hasNext()) {
            final Integer next = listIterator.next();
            System.out.println(next);
            if (next == 3) {
                listIterator.previous();
                break;
            }
        }

        final Compiler compiler = new CompilerConfigurator().getCompiler();
        final ByteCode byteCode = compiler.compile(new SourceCode() {
            @Override
            public String getModuleName() {
                return "test";
            }

            @Override
            public List<String> getLines() {
                return List.of(
                    "println ( HelloWorld )",
                    "",
                    "println ( HelloJava )"
                );
            }
        });
        System.out.println(byteCode.getCode());
    }

}
