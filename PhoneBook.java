import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения имени (ключ) и списка телефонов (значение)
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Пример входных данных с повторяющимися именами и разными телефонами
        String[][] inputData = {
            {"Alice", "123456"},
            {"Bob", "987654"},
            {"Alice", "999999"},
            {"Charlie", "111111"},
            {"Alice", "888888"},
            {"Bob", "777777"}
        };

        // Заполнение телефонной книги
        for (String[] entry : inputData) {
            String name = entry[0];
            String phone = entry[1];

            // Если имя уже есть в книге, добавляем новый телефон к существующему списку
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                // Иначе создаем новую запись с именем и телефоном
                Set<String> phones = new HashSet<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Создаем список записей (имя + количество телефонов) для сортировки
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        
        // Сортируем список записей по убыванию количества телефонов
        sortedEntries.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод отсортированных результатов
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            String name = entry.getKey();
            Set<String> phones = entry.getValue();
            System.out.println(name + ": " + phones.size() + " phones");

            // Вывод всех телефонов для данного имени
            for (String phone : phones) {
                System.out.println("\t" + phone);
            }
        }
    }
}