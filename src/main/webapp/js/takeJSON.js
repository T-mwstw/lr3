"use strict";

function req(){

    let Users = new Object();
    Users.name = document.getElementById("Name").value;
    Users.poroda = document.getElementById("Poroda").value;
    Users.age = document.getElementById("Age").value;
    Users.color = document.getElementById("Color").value;
    Users.warning = document.getElementById("Warning").value;

    $.ajax({
        type: 'POST',
        url: "http://localhost:8081/untitled8_war_exploded/AddingServlet?data=" + encodeURIComponent(JSON.stringify(Users)),
        success: function() {
            console.log('Данные успешно отправлены!');
        },
        error: function() {
            console.log('Произошла ошибка при отправке данных.');
        }
    });

    let inputs = document.getElementsByTagName("input");
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].value = "";
    }
}

