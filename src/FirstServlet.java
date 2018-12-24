import logic.ReqResWorker;
import logic.Observer.Observer;
import logic.SingletonHouse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.TimerTask;

public class FirstServlet extends javax.servlet.http.HttpServlet implements Observer {

    public static int count;

    HttpSession httpSession;
    HttpServletRequest request;
    HttpServletResponse response;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SingletonHouse.getInstance().addObserver(this);
    }

    protected void doPost
            (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        httpSession = request.getSession();

    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        httpSession = request.getSession();
        SingletonHouse.getInstance().addObserver(this);
        this.response = response;
        this.request = request;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FirstServlet)) return false;
        FirstServlet that = (FirstServlet) o;
        return Objects.equals(httpSession, that.httpSession);
    }


    @Override
    public int hashCode() {
        return httpSession != null ? httpSession.hashCode() : 0;
    }




    // Отслеживаем изменение в комнатах
    @Override
    public void handleEvent(List<Integer> rooms) {

        System.out.println("Произошло изменение " + rooms.toString());
    }
}
