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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import academy.devonline.javamm.code.fragment.SourceLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author drExpert666
 */

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class AbstractOperation_UnitTest {

    private static String TEXT = "text";

    @Mock
    private SourceLine sourceLine;

    private AbstractOperation abstractOperation;

    @BeforeEach
    void beforeEach() {
        abstractOperation = new AbstractOperation(sourceLine) {};
    }

    @Test
    void toString_should_delegate_the_call_to_SourceLine_toString() {
        when(sourceLine.toString()).thenReturn("REDIRECTED!");
        assertEquals("REDIRECTED!", abstractOperation.toString());
    }

}