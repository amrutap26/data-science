package com.softcell.datascience.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * Created by datalake on 27/12/17.
 */
public class Response {

    /**
     * The payload.
     */
    @JsonProperty ("body")
    private Payload<?> payload;

    /**
     * The status.
     */
    @JsonProperty("status")
    private Status status;

    /**
     * The errors.
     */
    @JsonProperty("errors")
    private Collection<Error> errors;

    @JsonProperty("error")
    private Error error;


    public Error getError() {
        return error;
    }


    public void setError(Error error) {
        this.error = error;
    }


    /**
     * Gets the payload.
     *
     * @return the payload
     */
    private Payload<?> getPayload() {
        return payload;
    }


    /**
     * Sets the payload.
     *
     * @param payload the payload to set
     */
    private void setPayload(Payload<?> payload) {
        this.payload = payload;
    }


    /**
     * Gets the status.
     *
     * @return the status
     */
    private Status getStatus() {
        return status;
    }


    /**
     * Sets the status.
     *
     * @param status the status to set
     */
    private void setStatus(Status status) {
        this.status = status;
    }


    /**
     * Gets the errors.
     *
     * @return the errors
     */
    private Collection<Error> getErrors() {
        return errors;
    }


    /**
     * Sets the errors.
     *
     * @param errors the errors to set
     */
    private void setErrors(Collection<Error> errors) {
        this.errors = errors;
    }


    /**
     * The Class Builder.
     */
    public static class Builder {

        /**
         * The base response.
         */
        private Response baseResponse = new Response();

        /**
         * Builds the.
         *
         * @return the response
         */
        public Response build() {
            return this.baseResponse;
        }

        /**
         * Payload.
         *
         * @param payload the payload
         * @return the builder
         */
        public Builder payload(Payload<?> payload) {
            this.baseResponse.setPayload(payload);
            return this;
        }

        /**
         * Errors.
         *
         * @param errors the errors
         * @return the builder
         */
        public Builder errors(Collection<Error> errors) {
            this.baseResponse.setErrors(errors);
            return this;
        }

        /**
         * Status.
         *
         * @param status the status
         * @return the builder
         */
        public Builder status(Status status) {
            this.baseResponse.setStatus(status);
            return this;
        }


        public Builder error(Error error) {
            this.baseResponse.setError(error);
            return this;

        }

    }
}

