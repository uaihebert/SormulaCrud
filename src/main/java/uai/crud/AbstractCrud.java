package uai.crud;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractCrud {
    protected static Date parseDate(String dateToBeParsed){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(dateToBeParsed);
        } catch (ParseException e) {
            return null;
        }
    }
}
