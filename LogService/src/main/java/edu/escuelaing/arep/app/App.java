package edu.escuelaing.arep.app;

import com.google.gson.Gson;
import edu.escuelaing.arep.app.model.Message;
import edu.escuelaing.arep.app.persistence.DBConnection;

import static spark.Spark.*;

public class App {
    /**
     * Metodo que se encarga de recibir las peticiones GET y POST
     * @param args Argumentos que entran a la clase principal.
     */
    public static void main( String[] args ) {
        port(getPort());
        DBConnection connection = new DBConnection();
        get("/messages", (req, res) -> {
            res.status(200);
            res.type("application/json");
            return new Gson().toJson(connection.getMessages());
        });
        post("/messages", (req, res) -> {
            Message a = new Message(req.body());
            connection.insertMessage(a);
            return null;
        });
    }

    /**
     * Este metodo lee por defecto el puerto dado por la variable PORT del entorno.
     * @return El puerto por defecto en local.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4561;
    }
}
