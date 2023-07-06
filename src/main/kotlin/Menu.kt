import kotlin.system.exitProcess

class MainMenu {
    private val archives = mutableListOf<Archive>()

    init {
        createMainMenu()
    }

    private fun createMainMenu() {
        while (true) {
            val newMutableList = mutableListOf<Pair<String, (Int) -> Unit>>(
                "Создать архив" to { createArchive() }
            )
            archives.forEachIndexed { index, archive ->
                newMutableList.add(
                    archive.name to { createArchiveMenu(index) }
                )
            }
            newMutableList.add(
                "Выход" to {
                    println("Завершение работы приложения.")
                    exitProcess(0)
                }
            )
            val mainMenu = MenuScreen(newMutableList)

            if (mainMenu.show()) break
        }
    }

    private fun createArchiveMenu(index: Int) {
        while (true) {
            val archive = archives[index]
            val newMutableList = mutableListOf<Pair<String, (Int) -> Unit>>(
                "Создать заметку" to { archive.addNote() }
            )
            archive.getNotes().forEach { note ->
                newMutableList.add(
                    note.title to { note.showNote() }
                )
            }
            newMutableList.add(
                "Назад" to {}
            )
            val archivesMenu = MenuScreen(newMutableList)

            if (archivesMenu.show()) break
        }
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readlnOrNull() ?: ""
        archives.add(Archive(name))
        println("Архив \"$name\" успешно создан.")
    }
}