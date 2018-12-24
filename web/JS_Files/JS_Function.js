
// Обработчик кнопки изменения состояния лампочки
function changeState(button, updateID, nameJSP, XMLHttpReguest, functionUpdateUI) {
    numberRoom = button.id; // получаем id нажатой кнопки
    XMLHttpReguest.open('POST', nameJSP, true);
    XMLHttpReguest.setRequestHeader("Content-Type",
        "application/x-www-form-urlencoded");
    XMLHttpReguest.onreadystatechange = functionUpdateUI;
    XMLHttpReguest.send("lamp=" + 100 + "&id=" + numberRoom);
}


