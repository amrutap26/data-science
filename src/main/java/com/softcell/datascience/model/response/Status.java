package com.softcell.datascience.model.response;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by datalake on 27/12/17.
 */
public class Status {

    /**
     * The status code.
     */
    @JsonProperty("iStatus")
    private int statusCode;

    /**
     * The status value.
     */
    @JsonProperty("sStatus")
    private String statusValue;

    /**
     * Builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sets the status code.
     *
     * @param statusCode the new status code
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Sets the status value.
     *
     * @param statusValue the new status value
     */
    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Status [statusCode=").append(statusCode)
                .append(", statusValue=").append(statusValue).append("]");
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((statusValue == null) ? 0 : statusValue.hashCode());
        result = prime * result + statusCode;
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
        Status other = (Status) obj;
        if (statusValue == null) {
            if (other.statusValue != null)
                return false;
        } else if (!statusValue.equals(other.statusValue))
            return false;
        if (statusCode != other.statusCode)
            return false;
        return true;
    }

    /**
     * The Class Builder.
     */
    public static class Builder {

        /**
         * The status.
         */
        private Status status = new Status();

        /**
         * Builds the.
         *
         * @return the status
         */
        public Status build() {
            return this.status;
        }

        /**
         * Status value.
         *
         * @param statusValue the status value
         * @return the builder
         */
        public Builder statusValue(String statusValue) {
            this.status.setStatusValue(statusValue);
            return this;
        }

        /**
         * Status code.
         *
         * @param statusCode the status code
         * @return the builder
         */
        public Builder statusCode(int statusCode) {
            this.status.setStatusCode(statusCode);
            return this;
        }
    }


}