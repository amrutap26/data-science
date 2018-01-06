package com.softcell.datascience.model.coreModel;

/**
 * Created by datalake on 4/1/18.
 */
public class FieldDetails {
    private String name;
    private String type;
    private String url;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FieldDetails{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", level=").append(level);
        sb.append('}');
        return sb.toString();
    }
}
