data class Note(val title: String, val text: String) {
    fun showNote() {
        with(this) {
            println("Заголовок: $title")
            println("Текст: $text")
        }
    }
}

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun addNote() {
        println("Введите название заметки:")
        val title = readlnOrNull() ?: ""
        println("Введите содержимое заметки:")
        val text = readlnOrNull() ?: ""
        notes.add(Note(title, text))
        println("Заметка добавлена.")
    }

    fun getNotes(): List<Note> {
        return notes.toList()
    }
}
