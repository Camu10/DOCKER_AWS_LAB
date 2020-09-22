package edu.escuelaing.arep.app.model;

import java.util.Date;

public class Message {
    private String info;
    private Date date;

    /**
     * Contructor de la clase Message
     * @param info String con la información que quiere almacenar.
     */
    public Message(String info){
        this.info=info;
        this.date = new Date();
    }

    /**
     * Contructor de la clase Mesaage
     * @param info String con la información que quiere almacenar.
     * @param date La fecha en la que el mensaje se realizó.
     */
    public Message(String info,Date date){
        this.info=info;
        this.date = date;
    }

    /**
     * Obtiene la información del mensaje.
     * @return String con la información que tiene el mensaje
     */
    public String getInfo() {
        return info;
    }

    /**
     * Actualiza la información del mensaje.
     * @param info String con la información que va a tener el mensaje.
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Obtiene la fecha del mensaje.
     * @return String con la información que tiene el mensaje
     */
    public Date getDate() {
        return date;
    }

    /**
     * Actualiza la fecha del mensaje.
     * @param date String con la fecha que va a tener el mensaje.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
