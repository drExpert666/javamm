/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
module javamm.code {
    requires lombok;

    // экспортируем все публичные классы из указанных пакетов
    // таким образом, людой модуль, который подключил к себе этот модуль может использовать эти классы в своих целях
    exports academy.devonline.javamm.code.fragment;
    exports academy.devonline.javamm.code.fragment.operation;
    exports academy.devonline.javamm.code.fragment.expression;
    exports academy.devonline.javamm.code.exception;
    exports academy.devonline.javamm.code.component;
    exports academy.devonline.javamm.code.syntax;


}