@FunctionalInterface
interface Transformer<T, R> {

    R transform(T input);

    default void printResult(T input) {
        R result = transform(input);
        System.out.println("Результат перетворення: " + result);
    }

    static boolean isNotNull(Object obj) {
        return obj != null;
    }
}

class Main {

    void main() {


        Transformer<String, Integer> stringLength = String::length;
        stringLength.printResult("Привіт, Java!");

        Transformer<Integer, Integer> doubleNumber = num -> num * 2;
        doubleNumber.printResult(15);

        System.out.println("Перевірка 1 (не null?): " + Transformer.isNotNull("Текст є"));
        System.out.println("Перевірка 2 (не null?): " + Transformer.isNotNull(null));
    }
}
