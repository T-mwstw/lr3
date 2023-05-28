package com.example.untitled8;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import User.*;
import Model.*;

import com.google.gson.*;

@WebServlet("/AddingServlet")
public class AddingServlet extends HttpServlet {
    Model dataModel = new Model(); //объект для хранения и обработки данных
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/take.jsp"); //перенаправление запроса на JSP-страницу
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 9.0\\webapps\\untitled8_war_exploded\src\\main\\webapp\\csv\\data.csv";
        String data = request.getParameter("data");
        System.out.println(data);
        Gson gson = new Gson();
        User gfg = gson.fromJson(data, User.class); //преобразования полученных данных JSON в объект класса User
        System.out.println(gfg.name);
        String[] row = {gfg.name, gfg.poroda, gfg.age, gfg.color, gfg.warning};
        dataModel.addData(row); //добавление строки
        dataModel.writeToCSV(filePath); //запись данных в CSV-файл
    }
}
//сервлет принимает данные из запроса, преобразует их в объект класса User, добавляет их в список данных и записывает список данных в файл.
