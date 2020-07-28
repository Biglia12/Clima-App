package com.example.clima_app.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyForecasts {

    @SerializedName("Date")
    String fecha;

    @SerializedName("EpochDate")
    Integer epochDate;

    @SerializedName("Temperature")
    Temperature temperature;

    @SerializedName("Day")
    Day day;

    @SerializedName("Night")
    Night night;

    @SerializedName("Sources")
    List<String> sources = null;

    @SerializedName("MobileLink")
    String mobileLink;

    @SerializedName("Link")
    String link;

    public String getFecha() {
        return fecha;
    }

    public Integer getEpochDate() {
        return epochDate;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Day getDay() {
        return day;
    }

    public Night getNight() {
        return night;
    }

    public List<String> getSources() {
        return sources;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public String getLink() {
        return link;
    }

    public class Temperature {
        @SerializedName("Minimum")
        Minimun minimun;
        @SerializedName("Maximum")
        Maximun maximun;

        public Minimun getMinimun() {
            return minimun;
        }

        public Maximun getMaximun() {
            return maximun;
        }
    }


    public class Minimun {
        @SerializedName("Value")
        Integer value;
        @SerializedName("Unit")
        String unit;
        @SerializedName("UnitType")
        Integer UnitType;

        public Integer getValue() {
            return value;
        }

        public String getUnit() {
            return unit;
        }

        public Integer getUnitType() {
            return UnitType;
        }
    }

    public class Maximun {
        @SerializedName("Value")
        Integer value;
        @SerializedName("Unit")
        String unit;
        @SerializedName("UnitType")
        Integer UnitType;

        public Integer getValue() {
            return value;
        }

        public String getUnit() {
            return unit;
        }

        public Integer getUnitType() {
            return UnitType;
        }
    }

    public class Day {
        @SerializedName("Icon")
        Integer Icon;
        @SerializedName("IconPhrase")
        String IconPhrase;
        @SerializedName("HasPrecipitation")
        boolean HasPrecipitation;
        @SerializedName("PrecipitationType")
        String PrecipitationType;
        @SerializedName("PrecipitationIntensity")
        String PrecipitationIntensity;

        public Integer getIcon() {
            return Icon;
        }

        public void setIcon(Integer icon) {
            Icon = icon;
        }

        public String getIconPhrase() {
            return IconPhrase;
        }

        public void setIconPhrase(String iconPhrase) {
            IconPhrase = iconPhrase;
        }

        public boolean isHasPrecipitation() {
            return HasPrecipitation;
        }

        public void setHasPrecipitation(boolean hasPrecipitation) {
            HasPrecipitation = hasPrecipitation;
        }

        public String getPrecipitationType() {
            return PrecipitationType;
        }

        public void setPrecipitationType(String precipitationType) {
            PrecipitationType = precipitationType;
        }

        public String getPrecipitationIntensity() {
            return PrecipitationIntensity;
        }

        public void setPrecipitationIntensity(String precipitationIntensity) {
            PrecipitationIntensity = precipitationIntensity;
        }
    }

    public class Night {
        @SerializedName("Icon")
        Integer Icon;
        @SerializedName("IconPhrase")
        String IconPhrase;
        @SerializedName("HasPrecipitation")
        boolean HasPrecipitation;
        String PrecipitationType;
        String PrecipitationIntensity;

        public Integer getIcon() {
            return Icon;
        }

        public void setIcon(Integer icon) {
            Icon = icon;
        }

        public String getIconPhrase() {
            return IconPhrase;
        }

        public void setIconPhrase(String iconPhrase) {
            IconPhrase = iconPhrase;
        }

        public boolean isHasPrecipitation() {
            return HasPrecipitation;
        }

        public void setHasPrecipitation(boolean hasPrecipitation) {
            HasPrecipitation = hasPrecipitation;
        }
    }

    public class Sources {
        String AccuWeather;
    }

}



