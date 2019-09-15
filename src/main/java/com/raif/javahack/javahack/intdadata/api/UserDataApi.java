package com.raif.javahack.javahack.intdadata.api;

import com.raif.javahack.javahack.intdadata.model.UserDto;
import org.json.JSONException;

import java.io.IOException;

public interface UserDataApi {
    UserDto getUserDataByInn(Long inn) throws JSONException, IOException;
}
