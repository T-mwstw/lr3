package com.example.untitled8;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.*;
import com.google.gson.*;
import User.*;
import Model.*;
import com.opencsv.exceptions.CsvException;

@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/output.jsp").forward(request, response); //перенаправление запроса на JSP-страницу

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String filePath = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 9.0\\webapps\\untitled8_war_exploded\src\\main\\webapp\\csv\\data.csv";
        //чтение данных из CSV-файла

        List<String[]> rows = new ArrayList<>(); //пустой список для хранения прочитанных данных из файла

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //открывается файл для чтения
            String line;
            while ((line = br.readLine()) != null) { //итерация по строкам
                String[] values = line.split(","); //разделение строк
                rows.add(values); //Разделенные значения сохраняются в массив, который добавляется в список
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String json = gson.toJson(rows); //преобразование списка в формат JSON
        System.out.println(json);

        PrintWriter out = response.getWriter(); //вывод данных в ответ на запрос
        out.println(json);
    }
}
