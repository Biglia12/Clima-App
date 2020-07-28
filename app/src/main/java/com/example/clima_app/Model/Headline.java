package com.example.clima_app.Model;

public class Headline {
         private String EffectiveDate;
         private int EffectiveEpochDate;
         private int Severity;
         private String Text;
         private String Category;
         private String EndDate;
         private int EndEpochDate;
         private String MobileLink;
         private String Link;

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public int getEffectiveEpochDate() {
        return EffectiveEpochDate;
    }

    public int getSeverity() {
        return Severity;
    }

    public String getText() {
        return Text;
    }

    public String getCategory() {
        return Category;
    }

    public String getEndDate() {
        return EndDate;
    }

    public int getEndEpochDate() {
        return EndEpochDate;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public String getLink() {
        return Link;
    }
}
