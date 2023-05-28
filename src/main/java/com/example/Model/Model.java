package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String[]> data;

    public Model() {
        data = new ArrayList<>();
    } //инициализируем пумтой список для хранения данных

    public List<String[]> getData() {
        return data;
    } //возвращаем текущий список данных

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public void addData(String[] rowData) {
        data.add(rowData);
    } //добавляем новую строку в список

    public void writeToCSV(String filePath) {  //записывает данные из списка data в файл CSV к файлу
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            for (String[] rowData : data) {  //итерация по строкам данных
                StringBuilder sb = new StringBuilder(); //Каждая строка данных конвертируется в строку CSV
                for (String value : rowData) {
                    sb.append(value).append(",");
                }
                writer.println(sb.toString().substring(0, sb.length() - 1)); //строка записывается в файл
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
