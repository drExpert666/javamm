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

package academy.devonline.javamm.code.fragment;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
// представляет строчку кода (используется паттерн ImmutableObject и NullObject)
public final class SourceLine implements Comparable<SourceLine>, CompiledCodeFragment {

    /* паттерн ImmutableObject - все поля final и private, доступ к полям только через getters, все листы
     следовательно поля закрыты для изменения
      Все листы делаем unmodifiable List - лист становится закрыт для изменения */
    public static final SourceLine EMPTY_SOURCE_LINE = new SourceLine("<UNDEFINED>", 0, List.of());

    // название файла, в котором объявлены строчки кода
    private final String moduleName;

    // номер строки
    private final int number;

    // список нормализированных токенов
    private List<String> tokens;

    public SourceLine(final String moduleName, final int number, final List<String> tokens) {
        // валидация, что передаваемые объект не null (паттерн NullObject)
        this.moduleName = requireNonNull(moduleName);
        this.number = number;
        // возвращает неизменяемый лист токенов, также каждый элемент
        // валидируется на not null (паттерн NullObject)
        this.tokens = List.copyOf(tokens);
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getNumber() {
        return number;
    }

    public List<String> getTokens() {
        return tokens;
    }

    // объеденённый набор токенов с помощью пробела
    public String getCommand() {
        return String.join(" ", tokens);
    }

    public String getToken(final int index) {
        return tokens.get(index);
    }

    public String getFirst() {
        return getToken(0);
    }

    public String getLast() {
        return getToken(getTokenCount() - 1);
    }

    private int getTokenCount() {
        return tokens.size();
    }

    public List<String> subList(final int start, final int end) {
        return tokens.subList(start, end);
    }

    public List<String> subList(final int start) {
        return tokens.subList(start, getTokenCount());
    }

    public boolean contains(final String token) {
        return tokens.contains(token);
    }

    public int indexOf(final String token) {
        return token.indexOf(token);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SourceLine that = (SourceLine) o;
        return number == that.number && Objects.equals(moduleName, that.moduleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleName, number);
    }

    @Override
    public int compareTo(final SourceLine o) {
        final int result = getModuleName().compareTo(o.getModuleName());
        if (result != 0) {
            return result;
        } else {
            return Integer.compare(number, o.number);
        }
    }



    @Override
    public String toString() {
        return String.format("[%s:%s] -> %s", moduleName, number, getCommand());
    }
}
