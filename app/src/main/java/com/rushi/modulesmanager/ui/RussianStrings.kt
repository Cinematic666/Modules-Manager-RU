package com.rushi.modulesmanager.ui

import java.util.Locale

/**
 * Lightweight UI translation layer. English remains the source language;
 * Russian is selected automatically when the device language is Russian.
 * Keep technical product names and protocol identifiers unchanged.
 */
internal fun tr(source: String): String {
    if (Locale.getDefault().language != "ru") return source
    russianStrings[source]?.let { return it }
    return when {
        source.contains("\nSeveral APKs fit this device equally well.") ->
            source.substringBefore("\n") + "\nДля этого устройства одинаково подходят несколько APK."
        source.startsWith("No module matches ") -> "Нет модулей, соответствующих запросу " + source.removePrefix("No module matches ")
        source.startsWith("Installing ") -> "Устанавливается: " + source.removePrefix("Installing ")
        source.startsWith("Last release ") -> "Последний релиз: " + source.removePrefix("Last release ")
        source.endsWith(" downloads") -> "Загрузок: " + source.removeSuffix(" downloads")
        source.startsWith("More by ") -> "Другие модули автора: " + source.removePrefix("More by ")
        source.startsWith("Uninstall ") && source.endsWith("?") ->
            "Удалить приложение " + source.removePrefix("Uninstall ").removeSuffix("?") + "?"
        source.startsWith("List updated ") -> "Список обновлён " + source.removePrefix("List updated ")
        source.startsWith("Installed ") -> "Установлено: " + source.removePrefix("Installed ")
        source.startsWith("Skipped ") -> "Пропущена версия " + source.removePrefix("Skipped ")
        source.startsWith("Updates ignored for ") -> "Обновления отключены для " + source.removePrefix("Updates ignored for ")
        source.startsWith("Following pre-releases for ") -> "Включены предварительные версии для " + source.removePrefix("Following pre-releases for ")
        source.startsWith("Updated ") && source.endsWith(" modules") ->
            "Обновлено модулей: " + source.removePrefix("Updated ").removeSuffix(" modules")
        source.startsWith("Updated ") && source.contains("; failed:") ->
            "Обновлено " + source.removePrefix("Updated ").replace("; failed:", "; ошибок:")
        source.startsWith("Uninstalled ") -> "Удалено: " + source.removePrefix("Uninstalled ")
        source.startsWith("Install failed: ") -> "Ошибка установки: " + source.removePrefix("Install failed: ")
        source.startsWith("Could not load releases from ") -> "Не удалось загрузить релизы из " + source.removePrefix("Could not load releases from ")
        source.startsWith("Linked to ") -> "Репозиторий подключён: " + source.removePrefix("Linked to ")
        source.startsWith("Source set to ") -> "Источник изменён: " + source.removePrefix("Source set to ")
        source.startsWith("No APK is available for ") -> "Для модуля нет доступного APK: " + source.removePrefix("No APK is available for ")
        source.endsWith(" installed") -> "Установлено: " + source.removeSuffix(" installed")
        source.startsWith("This release contains ") -> "Этот релиз содержит " + source.removePrefix("This release contains ")
        source.startsWith("This APK needs Android API ") -> "Для этого APK требуется Android API " + source.removePrefix("This APK needs Android API ")
        source.startsWith("This APK is built for ") -> "Этот APK собран для архитектур " + source.removePrefix("This APK is built for ")
        source.startsWith("Allow ") && source.contains(" for Modules Manager") -> "Выдайте разрешение " + source.removePrefix("Allow ").replace(" for Modules Manager, then try again", " для Менеджера модулей и повторите попытку")
        source.endsWith(", using the session installer") -> source.removeSuffix(", using the session installer") + ". Используется установщик сессий."
        source.endsWith(", opening the system uninstaller") -> source.removeSuffix(", opening the system uninstaller") + ". Открывается системное удаление."
        source.startsWith("Could not open ") -> "Не удалось открыть " + source.removePrefix("Could not open ")
        source.startsWith("No repository URL is configured for ") ->
            "Не настроен URL репозитория: " + source.removePrefix("No repository URL is configured for ")
        source.startsWith("All ") && source.contains(" endpoints failed.") ->
            "Не удалось обратиться к адресам репозитория (" + source.substringAfter("All ").substringBefore(" endpoints failed") + "). " +
                tr(source.substringAfter("endpoints failed. "))
        source.startsWith("Showing cached data. ") ->
            "Показаны сохранённые данные. " + tr(source.removePrefix("Showing cached data. "))
        source == "Cannot reach the repository. Check your connection." -> "Не удалось подключиться к репозиторию. Проверьте соединение."
        source == "The repository took too long to respond." -> "Репозиторий слишком долго не отвечает."
        source == "The repository's certificate could not be validated. Try another source." -> "Не удалось проверить сертификат репозитория. Попробуйте другой источник."
        source == "That URL did not return a valid modules.json file." -> "По этой ссылке не получен корректный файл modules.json."
        source == "The repository refused the request (HTTP 403). Try another source." -> "Репозиторий отклонил запрос (HTTP 403). Попробуйте другой источник."
        source == "No modules.json was found at this repository URL." -> "По этой ссылке не найден файл modules.json."
        source == "Could not load the repository." -> "Не удалось загрузить репозиторий."
        source.startsWith("Build: ") -> "Сборка: " + source.removePrefix("Build: ")
        source.startsWith("Android: ") -> "Android: " + source.removePrefix("Android: ")
        source.startsWith("Device: ") -> "Устройство: " + source.removePrefix("Device: ")
        source.startsWith("ABIs: ") -> "Архитектуры: " + source.removePrefix("ABIs: ")
        source.startsWith("Installed modules: ") -> "Установленные модули: " + source.removePrefix("Installed modules: ")
        source.startsWith("Repository modules: ") -> "Модули в каталоге: " + source.removePrefix("Repository modules: ")
        source.startsWith("Updates available: ") -> "Доступные обновления: " + source.removePrefix("Updates available: ")
        source.startsWith("Index and README cache: ") -> "Кэш каталога и README: " + source.removePrefix("Index and README cache: ")
        source.startsWith("Downloaded APKs: ") -> "Загруженные APK: " + source.removePrefix("Downloaded APKs: ")
        source.startsWith("Modules Manager ") -> "Менеджер модулей " + source.removePrefix("Modules Manager ")
        source.startsWith("Update all (") -> "Обновить все (" + source.removePrefix("Update all (")
        source.endsWith(" sources") -> "Источников: " + source.removeSuffix(" sources")
        source.endsWith(" at a time") -> "Одновременно: " + source.removeSuffix(" at a time")
        source.endsWith(" of " + source.substringAfter(" of ", "")) && source.contains(" of ") ->
            source.replace(" of ", " из ")
        source.startsWith("No description") -> "Описание отсутствует"
        source == "Translation failed" -> "Не удалось выполнить перевод"
        else -> source
    }
}

private val russianStrings = mapOf(
    "Modules" to "Модули",
    "Installed" to "Установлено",
    "Library" to "Библиотека",
    "Settings" to "Настройки",
    "Choose an APK" to "Выберите APK",
    "Several APKs fit this device equally well." to "Для этого устройства подходят несколько APK с одинаковым приоритетом.",
    "Cancel" to "Отмена",
    "Dismiss" to "Закрыть",
    "Not installed" to "Не установлено",
    "Search modules" to "Поиск модулей",
    "Clear search" to "Очистить поиск",
    "Loading modules..." to "Загрузка модулей…",
    "Repository unavailable" to "Репозиторий недоступен",
    "No modules were found in the repository." to "В репозитории не найдено модулей.",
    "Retry" to "Повторить",
    "Nothing here" to "Здесь пока пусто",
    "Every installed module is up to date." to "Все установленные модули обновлены до последних версий.",
    "None of your installed modules are in this repository." to "В этом репозитории нет ни одного из установленных модулей.",
    "Every module in this repository is installed." to "Все модули этого репозитория уже установлены.",
    "Recently updated" to "Недавно обновлённые",
    "Most starred" to "Самые популярные",
    "Scroll to top" to "Наверх",
    "Refresh" to "Обновить",
    "Sort" to "Сортировка",
    "Sort by name" to "По названию",
    "Sort by last update" to "По дате обновления",
    "Sort by recently added" to "По дате добавления",
    "Sort by stars" to "По количеству звёзд",
    "Sort by sources" to "По количеству источников",
    "Updates first" to "Сначала с обновлениями",
    "No release" to "Нет релиза",
    "Remove from favourites" to "Убрать из избранного",
    "Add to favourites" to "В избранное",
    "Show less" to "Свернуть",
    "Read more" to "Читать далее",
    "Show original" to "Показать оригинал",
    "Translate" to "Перевести",
    "More actions" to "Действия",
    "More by \$developer" to "Другие модули автора: \$developer",
    "Copy package name" to "Копировать имя пакета",
    "Package name copied" to "Имя пакета скопировано",
    "Open releases page" to "Открыть страницу релизов",
    "Search installed" to "Поиск установленных",
    "Update all (\${updates.size})" to "Обновить все (\${updates.size})",
    "No installed modules found" to "Установленные модули не найдены",
    "Nothing to update" to "Нет доступных обновлений",
    "Nothing is skipped" to "Нет пропущенных версий",
    "All modules are tracked" to "Все модули отслеживаются",
    "Install modules from the Modules tab, then enable them in LSPosed." to "Установите модули на вкладке «Модули», затем включите их в LSPosed.",
    "All installed modules are on their latest version." to "Все установленные модули обновлены до последних версий.",
    "No installed module has a skipped version or ignored updates." to "Нет модулей с пропущенными версиями или отключёнными обновлениями.",
    "Every installed module has an entry in the daily index." to "Все установленные модули присутствуют в ежедневном каталоге.",
    "Uninstall" to "Удалить",
    "Uninstall \${module.label}?" to "Удалить приложение «\${module.label}»?",
    "This removes the app from the device. You can install it again from the Modules tab." to "Приложение будет удалено с устройства. Вы сможете установить его снова на вкладке «Модули».",
    "Link manually" to "Добавить вручную",
    "Paste the GitHub repository for \$label. Its releases will be used for updates." to "Укажите репозиторий GitHub для \$label. Его релизы будут использоваться для обновлений.",
    "Link" to "Добавить",
    "Skip this version" to "Пропустить эту версию",
    "Clear skipped version" to "Сбросить пропуск версии",
    "Restore updates" to "Возобновить обновления",
    "Ignore updates" to "Не получать обновления",
    "Unlink manual repository" to "Отвязать репозиторий",
    "Follow pre-releases" to "Получать предварительные версии",
    "View module" to "Открыть модуль",
    "App info" to "О приложении",
    "Favourites" to "Избранное",
    "Recent" to "Недавние",
    "No favourites yet" to "Пока нет избранного",
    "Tap the heart on a module card or module page to keep it here." to "Нажмите на сердечко в карточке или на странице модуля, чтобы добавить его сюда.",
    "Nothing viewed yet" to "Вы ещё ничего не открывали",
    "Modules you open show up here." to "Открытые вами модули будут отображаться здесь.",
    "Overview" to "Обзор",
    "Releases" to "Релизы",
    "Back" to "Назад",
    "Translate README" to "Перевести README",
    "Translate release notes" to "Перевести описание релиза",
    "Show translation" to "Показать перевод",
    "Set source repository" to "Выбрать репозиторий-источник",
    "Loading module details..." to "Загрузка информации о модуле…",
    "Module not found" to "Модуль не найден",
    "This module is not part of the selected repository." to "Этого модуля нет в выбранном репозитории.",
    "Repositories in the index" to "Репозитории в каталоге",
    "Current" to "Текущий",
    "Or enter another repository" to "Или укажите другой репозиторий",
    "owner/repo or https://github.com/owner/repo" to "owner/repo или https://github.com/owner/repo",
    "Save" to "Сохранить",
    "Reset" to "Сбросить",
    "Open" to "Открыть",
    "Install" to "Установить",
    "No description" to "Описание отсутствует",
    "This module has not published a README." to "Для этого модуля не опубликован README.",
    "Loading releases..." to "Загрузка релизов…",
    "No releases" to "Релизов нет",
    "This module has not published any releases on GitHub." to "Для этого модуля ещё не опубликовано ни одного релиза на GitHub.",
    "Unknown date" to "Неизвестная дата",
    "Pre-release" to "Предварительный релиз",
    "Open release page" to "Открыть страницу релиза",
    "No APK attached to this release" to "К этому релизу не приложен APK",
    "Appearance" to "Внешний вид",
    "AMOLED mode" to "Режим AMOLED",
    "Pitch black backgrounds when the dark theme is active" to "Абсолютно чёрный фон при использовании тёмной темы",
    "System colors" to "Системные цвета",
    "Material You colors on Android 12+" to "Цвета Material You на Android 12 и новее",
    "Theme" to "Тема",
    "Translation" to "Перевод",
    "Translate automatically" to "Переводить автоматически",
    "Translate module descriptions and READMEs when they load" to "Переводить описания модулей и README при загрузке",
    "Language" to "Язык",
    "Check for updates" to "Проверять обновления",
    "Installer" to "Установщик",
    "Update channel" to "Канал обновлений",
    "Concurrent downloads" to "Одновременные загрузки",
    "About" to "О приложении",
    "Buy me a coffee" to "Поддержать разработчика",
    "Modules Manager" to "Менеджер модулей",
    "Device, build and cache details" to "Сведения об устройстве, сборке и кэше",
    "View on GitHub" to "Открыть на GitHub",
    "Close" to "Закрыть",
    "Translation language" to "Язык перевода",
    "Device language" to "Язык устройства",
    "Default" to "По умолчанию",
    "Start" to "Запустить",
    "Allow" to "Разрешить",
    "Storage" to "Хранилище",
    "Index and README cache" to "Кэш каталога и README",
    "Downloaded APKs" to "Загруженные APK",
    "Clear" to "Очистить",
    "Report copied" to "Отчёт скопирован",
    "Copy" to "Копировать",
    "Share diagnostics" to "Поделиться диагностикой",
    "Share" to "Поделиться",
    "No modules" to "Нет модулей",
    "This developer has no other modules in the current repository." to "У этого разработчика нет других модулей в текущем репозитории.",
    "Repository unavailable" to "Репозиторий недоступен",
    "Loading modules..." to "Загрузка модулей…",
    "Loading module details..." to "Загрузка информации о модуле…",
    "Loading releases..." to "Загрузка релизов…",
    "No release" to "Нет релиза",
    "1 target" to "1 целевое приложение",
    "\${module.scope.size} targets" to "Целевых приложений: \${module.scope.size}",
    "Updates ignored" to "Обновления отключены",
    "Up to date" to "Актуальная версия",
    "Update" to "Обновить",
    "Update failed" to "Не удалось обновить",
    "Queued" to "В очереди",
    "Downloading" to "Загрузка",
    "Waiting to install" to "Ожидание установки",
    "Installing" to "Установка",
    "Cancelled" to "Отменено",
    "Cancel this update" to "Отменить это обновление",
    "Preparing updates" to "Подготовка обновлений",
    "Updates interrupted" to "Обновление прервано",
    "\${state.finished} of \${state.total} done" to "Выполнено: \${state.finished} из \${state.total}",
    " - \${failedItems.size} failed" to " — ошибок: \${failedItems.size}",
    "1 module" to "1 модуль",
    "\${entries.size} modules" to "Модулей: \${entries.size}",
    "List updated \${formatRelativeTime(stamp)}" to "Список обновлён \${formatRelativeTime(stamp)}",
    "\$concurrentDownloads at a time" to "Одновременно: \$concurrentDownloads",
    "\$count at a time" to "Одновременно: \$count",
    "\${theme.label} - \${theme.description}" to "\${theme.label} — \${theme.description}",
    "\${TranslationLanguages.selectedLabel(null)} (device language)" to "\${TranslationLanguages.selectedLabel(null)} (язык устройства)",
    "Shizuku is running and allowed" to "Shizuku запущен, разрешение выдано",
    "Shizuku permission is not granted" to "Нет разрешения Shizuku",
    "Shizuku is not running" to "Shizuku не запущен",
    "Report copied" to "Отчёт скопирован",
    "Build: \${BuildConfig.BUILD_TYPE} \${BuildConfig.GIT_COMMIT}" to "Сборка: \${BuildConfig.BUILD_TYPE} \${BuildConfig.GIT_COMMIT}",
    "Android: \${Build.VERSION.RELEASE} (API \${Build.VERSION.SDK_INT})" to "Android: \${Build.VERSION.RELEASE} (API \${Build.VERSION.SDK_INT})",
    "Device: \${Build.MANUFACTURER} \${Build.MODEL}" to "Устройство: \${Build.MANUFACTURER} \${Build.MODEL}",
    "ABIs: \${Build.SUPPORTED_ABIS.joinToString()}" to "Архитектуры: \${Build.SUPPORTED_ABIS.joinToString()}",
    "Installed modules: \${installed.size}" to "Установленные модули: \${installed.size}",
    "Repository modules: \${modules.size}" to "Модули в каталоге: \${modules.size}",
    "Updates available: \${updates.size}" to "Доступные обновления: \${updates.size}",
    "Index and README cache: \${formatStorage(stats.index + stats.readme)}" to "Кэш каталога и README: \${formatStorage(stats.index + stats.readme)}",
    "Downloaded APKs: \${formatStorage(stats.apks)}" to "Загруженные APK: \${formatStorage(stats.apks)}",
    "Modules Manager \${BuildConfig.VERSION_NAME} (\${BuildConfig.VERSION_CODE})" to "Менеджер модулей \${BuildConfig.VERSION_NAME} (\${BuildConfig.VERSION_CODE})",
    "Choose an APK" to "Выберите APK",
    "Install cancelled" to "Установка отменена",
    "Install failed" to "Не удалось установить",
    "No link available" to "Ссылка недоступна",
    "Could not open app info" to "Не удалось открыть сведения о приложении",
    "This module has no settings screen" to "У этого модуля нет экрана настроек",
    "All" to "Все",
    "Updates" to "Обновления",
    "Installed" to "Установленные",
    "Skipped" to "Пропущенные",
    "Untracked" to "Не отслеживаются",
    "Rescan installed modules" to "Повторно проверить установленные модули",
    "Used for the owner, avatar, README and release links when the index points to a fork or the wrong repository." to "Используется для ссылок на автора, аватар, README и релизы, если каталог указывает на форк или неверный репозиторий.",
    "\$sourceCount sources" to "Источников: \$sourceCount",
    "package name" to "имя пакета",
    "Release" to "Релиз",
    "Resume download" to "Возобновить загрузку",
    "Pause download" to "Приостановить загрузку",
    "Cancel download" to "Отменить загрузку",
    "Verifying package..." to "Проверка пакета…",
    "Opening the installer..." to "Открытие установщика…",
    "Paused - \${formatBytes(state.downloaded)} of \$total" to "Приостановлено — \${formatBytes(state.downloaded)} из \$total",
    "\${formatBytes(state.downloaded)} of \$total" to "\${formatBytes(state.downloaded)} из \$total",
    "unknown size" to "неизвестный размер",
    "Diagnostics" to "Диагностика",
    "Rescanned installed modules" to "Список установленных модулей обновлён",
    "Index cache cleared" to "Кэш каталога очищен",
    "Downloaded APKs cleared" to "Загруженные APK удалены",
    "Shizuku permission is already granted" to "Разрешение Shizuku уже выдано",
    "Start Shizuku, then choose Shizuku again" to "Запустите Shizuku, затем снова выберите Shizuku",
    "Shizuku permission granted" to "Разрешение Shizuku выдано",
    "Shizuku permission was not granted" to "Разрешение Shizuku не выдано",
    "Shizuku is not installed" to "Shizuku не установлен",
    "This module is not available in the selected repository." to "Этот модуль недоступен в выбранном репозитории.",
    "This README has no Markdown text that can be translated" to "В README нет текста Markdown для перевода",
    "This README is already in \${displayLanguage(target)}" to "README уже на языке \${displayLanguage(target)}",
    "Could not translate this README" to "Не удалось перевести README",
    "These release notes have no text that can be translated" to "В описании релиза нет текста для перевода",
    "Release notes are already in \${displayLanguage(target)}" to "Описание релиза уже на языке \${displayLanguage(target)}",
    "Could not translate these release notes" to "Не удалось перевести описание релиза",
    "There is no version to skip" to "Нет версии, которую можно пропустить",
    "Skipped version cleared" to "Пропуск версии сброшен",
    "Added to favourites" to "Добавлено в избранное",
    "Removed from favourites" to "Удалено из избранного",
    "Updates restored" to "Обновления возобновлены",
    "Following stable releases" to "Используются только стабильные релизы",
    "Paste a GitHub URL like https://github.com/owner/repo" to "Вставьте ссылку на GitHub, например https://github.com/owner/repo",
    "Could not open releases from \$repo" to "Не удалось открыть релизы из \$repo",
    "Manual link removed" to "Ручная привязка удалена",
    "Source reset to the index" to "Источник сброшен на значение из каталога",
    "Wait for the current install to finish" to "Дождитесь завершения текущей установки",
    "Opening the system installer" to "Открывается системный установщик",
    "The installer did not confirm the install" to "Установщик не подтвердил завершение установки",
    "The downloaded file is not a valid APK" to "Загруженный файл не является корректным APK",
    "This release is older than the installed version" to "Этот релиз старее установленной версии",
    "Could not open a system installer" to "Не удалось открыть системный установщик",
    "Root access is not granted, using the session installer" to "Нет root-доступа. Используется системный установщик сессий",
    "Allow unknown apps for Modules Manager, then try again" to "Разрешите установку неизвестных приложений для Менеджера модулей и повторите попытку",
    "The install timed out" to "Время ожидания установки истекло",
    "The app restarted before this finished" to "Приложение перезапустилось до завершения операции",
    "No updates available" to "Нет доступных обновлений",
    "Repository is serving an older release" to "В репозитории опубликована более старая версия",
    "No APK asset" to "В релизе нет APK-файла",
    "Update all cancelled" to "Обновление всех модулей отменено",
    "The repository is still serving an older release" to "В репозитории всё ещё опубликована более старая версия",
    "This module has no description to translate" to "У этого модуля нет описания для перевода",
    "This description is already in \${displayLanguage(target)}" to "Описание уже на языке \${displayLanguage(target)}",
    "This module has no settings screen" to "У этого модуля нет экрана настроек",
    "Could not open app info" to "Не удалось открыть сведения о приложении",
    "Could not open the uninstaller" to "Не удалось открыть деинсталлятор",
    "No app can open this link" to "Нет приложения для открытия этой ссылки",
    "Install cancelled" to "Установка отменена",
    "The system blocked the install. Allow unknown apps for Modules Manager and try again" to "Система заблокировала установку. Разрешите установку неизвестных приложений для Менеджера модулей и повторите попытку",
    "The installed app conflicts with this APK, usually because the signing keys differ" to "Установленное приложение конфликтует с этим APK. Обычно причина — разные ключи подписи",
    "This APK is not compatible with this device" to "Этот APK несовместим с устройством",
    "Not enough storage to install this APK" to "Недостаточно места для установки APK",
    "Install failed" to "Не удалось установить приложение",
    "System" to "Системная",
    "Follow the device theme" to "Следовать теме устройства",
    "Light" to "Светлая",
    "Always use the light theme" to "Всегда использовать светлую тему",
    "Dark" to "Тёмная",
    "Always use the dark theme" to "Всегда использовать тёмную тему",
    "System installer" to "Системный установщик",
    "Open the APK in the system package installer" to "Открывать APK в системном установщике приложений",
    "Session installer" to "Установщик сессий",
    "Use a PackageInstaller session and the system confirmation" to "Использовать сессию PackageInstaller с системным подтверждением",
    "Install silently through Shizuku, which must be running and allowed" to "Устанавливать без подтверждения через запущенный Shizuku с выданным разрешением",
    "Install silently through a root shell. Your root manager must allow Modules Manager." to "Устанавливать без подтверждения через root. Менеджеру модулей необходимо выдать root-доступ.",
    "Stable" to "Стабильные",
    "Released versions only" to "Только опубликованные стабильные версии",
    "Include pre-release builds" to "Включая предварительные сборки",
    "Name" to "По названию",
    "Last updated" to "По дате обновления",
    "Recently added" to "Недавно добавленные",
    "Most starred" to "Самые популярные",
    "Most sources" to "По количеству источников",
    "Updates" to "Обновления",
    "Diagnostics" to "Диагностика",
    "System colors" to "Системные цвета",
    "Translation" to "Перевод",
    "About" to "О приложении",
    "1 at a time" to "Одновременно: 1",
    "2 at a time" to "Одновременно: 2",
    "3 at a time" to "Одновременно: 3",
    "4 at a time" to "Одновременно: 4",
    "5 at a time" to "Одновременно: 5",
    "Start Shizuku, then choose Shizuku again" to "Запустите Shizuku, затем выберите его повторно",
    "Root access is not granted, using the session installer" to "Root-доступ не выдан. Используется системный установщик сессий",
    "Root access is not granted, opening the system uninstaller" to "Root-доступ не выдан. Открывается системный деинсталлятор",
    "Shizuku is not running" to "Shizuku не запущен",
    "Shizuku permission was not granted" to "Разрешение Shizuku не выдано",
    "This module is not available in the selected repository." to "Этот модуль недоступен в выбранном репозитории.",
    "Opening the system installer" to "Открывается системный установщик",
    "The app restarted before this finished" to "Приложение перезапустилось до завершения операции",
    "No updates available" to "Нет доступных обновлений",
    "No APK asset" to "В релизе отсутствует APK-файл",
    "Update all cancelled" to "Обновление всех модулей отменено",
    "Source reset to the index" to "Источник сброшен на запись из каталога",
    "Could not translate this README" to "Не удалось перевести README",
    "Could not translate these release notes" to "Не удалось перевести описание релиза",
    "Could not open a system installer" to "Не удалось открыть системный установщик",
    "Could not open app info" to "Не удалось открыть сведения о приложении",
    "Could not open the uninstaller" to "Не удалось открыть деинсталлятор",
    "No link available" to "Ссылка недоступна",
    "No app can open this link" to "Нет приложения, способного открыть эту ссылку",
    "Install failed: \$it" to "Ошибка установки: \$it",
    "Modules Manager diagnostics" to "Диагностика Менеджера модулей",
    "The index cache is fetched again after clearing. Downloaded APKs are only needed until the installer finishes." to "После очистки кэш каталога будет загружен заново. Скачанные APK нужны только до завершения установки."
)
