package com.example.dragneel.bookhub;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dragneel on 5/2/17.
 */

public class loginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL = "127.0.0.1";
    private Map<String, String> params;

    public loginRequest(String username, String password, Response.Listener<String> listener)
    {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("uname",username);
        params.put("pswd",password);
    }

    public Map<String, String> getParams()
    {
        return params;
    }
}
