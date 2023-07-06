import java.util.*

class MenuScreen(private val options: List<Pair<String, (index: Int) -> Unit>>) {
    private val scanner = Scanner(System.`in`)

    fun show(): Boolean {
        println("Выберите пункт меню:")
        options.forEachIndexed { index, option -> println("$index. ${option.first}") }

        val input = scanner.nextLine().toIntOrNull()
        if (input == null) {
            println("Некорректный ввод. Пожалуйста, введите цифру номера меню.")
            return false
        }

        if (input < 0 || input >= options.size) {
            println("Некорректный ввод. Такого пункта меню не существует.")
            return false
        }

        val selectedOption = options[input]
        selectedOption.second(input)

        return input == options.size - 1
    }
}
