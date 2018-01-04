package com.softcell.datascience.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by datalake on 27/12/17.
 */


public class Error {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;


    /**
     * The id.
     */
    @JsonProperty("errorId")
    private String id;

    /**
     * The field name.
     */
    @JsonProperty("fieldName")
    private String fieldName;

    /**
     * The error type.
     */
    @JsonProperty("errorType")
    private String errorType;

    /**
     * The error code.
     */
    @JsonProperty("errorCode")
    private String errorCode;

    /**
     * The message.
     */
    @JsonProperty("message")
    private String message;

    /**
     * The level.
     */
    @JsonProperty("level")
    private String level;

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the field name.
     *
     * @param fieldName the new field name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets the error type.
     *
     * @return the error type
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * Sets the error type.
     *
     * @param errorType the new error type
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     *
     * @param errorCode the new error code
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the level.
     *
     * @param level the new level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Error [id=");
        builder.append(id);
        builder.append(", fieldName=");
        builder.append(fieldName);
        builder.append(", errorType=");
        builder.append(errorType);
        builder.append(", errorCode=");
        builder.append(errorCode);
        builder.append(", message=");
        builder.append(message);
        builder.append(", level=");
        builder.append(level);
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
        result = prime * result
                + ((errorCode == null) ? 0 : errorCode.hashCode());
        result = prime * result
                + ((errorType == null) ? 0 : errorType.hashCode());
        result = prime * result
                + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
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
        Error other = (Error) obj;
        if (errorCode == null) {
            if (other.errorCode != null)
                return false;
        } else if (!errorCode.equals(other.errorCode))
            return false;
        if (errorType == null) {
            if (other.errorType != null)
                return false;
        } else if (!errorType.equals(other.errorType))
            return false;
        if (fieldName == null) {
            if (other.fieldName != null)
                return false;
        } else if (!fieldName.equals(other.fieldName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        return true;
    }


    /**
     * The Enum SEVERITY.
     */
    public enum SEVERITY {

        /**
         * The critical.
         */
        CRITICAL,

        /**
         * The high.
         */
        HIGH,

        /**
         * The medium.
         */
        MEDIUM,

        /**
         * The low.
         */
        LOW
    }

    /**
     * The Enum ERROR_TYPE.
     */
    public enum ERROR_TYPE {

        /**
         * The system.
         */
        SYSTEM("SYSTEM", 1000),

        /**
         * The business.
         */
        BUSINESS("BUSINESS", 2000),

        /**
         * The database.
         */
        DATABASE("DATABASE", 3000);

        /**
         * The code.
         */
        private int code;

        /**
         * The value.
         */
        private String value;

        /**
         * Instantiates a new error type.
         *
         * @param value the value
         * @param code  the code
         */
        private ERROR_TYPE(final String value, final int code) {
            this.code = code;
            this.value = value;
        }

        /**
         * To value.
         *
         * @return the string
         */
        public String toValue() {
            return value;
        }

        /**
         * To code.
         *
         * @return the int
         */
        public int toCode() {
            return code;
        }


    }

    /**
     * The Class Builder.
     */
    public static class Builder {

        /**
         * The error.
         */
        private Error error = new Error();

        /**
         * Builds the.
         *
         * @return the error
         */
        public Error build() {
            return error;
        }

        /**
         * Id.
         *
         * @param id the id
         * @return the builder
         */
        public Builder id(String id) {
            this.error.id = id;
            return this;
        }

        /**
         * Field name.
         *
         * @param fieldName the field name
         * @return the builder
         */
        public Builder fieldName(String fieldName) {

            this.error.setFieldName(fieldName);

            return this;
        }

        /**
         * Error type.
         *
         * @param errorType the error type
         * @return the builder
         */
        public Builder errorType(String errorType) {

            this.error.setErrorType(errorType);

            return this;
        }

        /**
         * Error code.
         *
         * @param errorCode the error code
         * @return the builder
         */
        public Builder errorCode(String errorCode) {

            this.error.setErrorCode(errorCode);

            return this;
        }

        /**
         * Message.
         *
         * @param message the message
         * @return the builder
         */
        public Builder message(String message) {

            this.error.setMessage(message);

            return this;
        }

        /**
         * Level.
         *
         * @param level the level
         * @return the builder
         */
        public Builder level(String level) {

            this.error.setLevel(level);
            return this;
        }

    }


}