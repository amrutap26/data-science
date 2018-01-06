package com.softcell.datascience.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;


/**
 * Created by datalake on 27/12/17.
 */

public class Payload<T> {

    /**
     * The t.
     */
    @JsonProperty("payLoad")
    private T t;

    /**
     * Instantiates a new payload.
     *
     * @param body the body
     */
    public Payload(T body) {
        Assert.notNull(body);
        this.t = body;
    }

    /**
     * Gets the t.
     *
     * @return the t
     */
    public T getT() {
        return t;
    }

    /**
     * Sets the t.
     *
     * @param t the new t
     */
    public void setT(T t) {
        this.t = t;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("ResponsePayload [t=");
        builder.append(t);
        builder.append(", getT()=");
        builder.append(getT());
        builder.append(", getClass()=");
        builder.append(getClass());
        builder.append(", hashCode()=");
        builder.append(hashCode());
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((t == null) ? 0 : t.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Payload other = (Payload) obj;
        if (t == null) {
            if (other.t != null)
                return false;
        } else if (!t.equals(other.t))
            return false;
        return true;
    }

}
