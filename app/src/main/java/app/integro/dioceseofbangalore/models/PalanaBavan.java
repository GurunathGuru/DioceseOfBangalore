package app.integro.dioceseofbangalore.models;

import java.io.Serializable;

public class PalanaBavan implements Serializable {

    private String name;

    private String id;

    private String updated_date;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUpdated_date ()
    {
        return updated_date;
    }

    public void setUpdated_date (String updated_date)
    {
        this.updated_date = updated_date;
    }

}
