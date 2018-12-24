package logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static logic.SingletonHouse.*;

public class ReqResWorker {
    HttpServletRequest request;
    HttpServletResponse response;

    public ReqResWorker(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public synchronized void checkResponse() {
        String lamp = request.getParameter("lamp");
        String id = request.getParameter("id");
        System.out.println("Lamp = " + lamp);
        System.out.println("ID = " + id);
        try {
                if (lamp != null && lamp.equals("100")) {
                    changeLamp(id);
                    System.out.println(Arrays.toString(getInstance().getArray()));
                    printState(id);
                } else if (lamp != null && lamp.equals("200")) {
                    printState(id);
                } else if (lamp != null && lamp.equals("300")) {
                    printStateRoom();
                } else {
                    System.out.println("Неизвестный запрос");
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void changeLamp(String id) {
        int number = Integer.valueOf(id);
        getInstance().change(number);
    }

    public void printState(String id) throws IOException {
        int number = Integer.valueOf(id);
        response.getWriter().print("<h1>" + getInstance().getState(number) + "</h1>");

    }

    public void printStateRoom() throws IOException {
        response.getWriter().print("<h1>" + Arrays.toString(getInstance().getArray()) + "</h1>");
    }

}
