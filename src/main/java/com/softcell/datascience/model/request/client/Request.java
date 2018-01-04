package com.softcell.datascience.model.request.client;

/**
 * Created by datalake on 27/12/17.
 */
public class Request<RequestBody> {

    private RequestBody requestBody;

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
}
