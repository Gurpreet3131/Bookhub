package com.example.dragneel.bookhub;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dragneel on 5/2/17.
 */

public class registerRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "127.0.0.1";
    private Map<String, String> params;

    public registerRequest(String firstName, String username, String email, String contact, String password, Response.Listener<String> listener)
    {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("uname",username);
        params.put("pswd",password);
        params.put("name",firstName);
        params.put("email",email);
        params.put("mobile",contact);
    }

    public Map<String, String> getParams()
    {
        return params;
    }


}
